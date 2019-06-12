package com.api.linkshortner.serviceImpl;

import com.api.linkshortner.model.Link;
import com.api.linkshortner.repository.LinkRepository;
import com.api.linkshortner.service.HashService;
import com.api.linkshortner.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LinkServiceImpl implements LinkService {
    private LinkRepository linkRepository;
    private HashService shortenService;

    @Autowired
    public LinkServiceImpl(HashService shortenService, LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
        this.shortenService = shortenService;
    }

    @Override
    @Transactional
    public Link create(String url) {
        Link resultLink;

        Link existingLink = linkRepository.findByUrl(url);
        if(existingLink != null) {
            resultLink = existingLink;
        }
        else {
            resultLink = createAndSaveLink(url);
        }
        return resultLink;
    }

    @Override
    @Transactional
    public List<Link> find() {
        List<Link> foundLinks = linkRepository.findAll();
        return foundLinks;
    }

    @Override
    public String findUrlByHash(String hash) {
        String url;
        Link foundLink = linkRepository.findByHash(hash);
        if(foundLink == null) {
            url = "This url is not yet shortned";
        } else {
            url = foundLink.getUrl();
        }
        return url;
    }

    private Link createAndSaveLink(String url) {
        String hash = shortenService.shorten(url);
        Link requestedLink = new Link();
        requestedLink.setUrl(url);
        requestedLink.setHash(hash);
        Link savedLink = linkRepository.save(requestedLink);
        return savedLink;
    }
}











