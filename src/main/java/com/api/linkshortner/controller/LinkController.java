package com.api.linkshortner.controller;


import com.api.linkshortner.model.Link;
import com.api.linkshortner.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(LinkController.LINKS)
public class LinkController {
    public static final String LINKS = "/links";
    private LinkService linkService;

    @Autowired
    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_FORM_URLENCODED_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Link> createShortLink(@RequestParam(value = "url") String longUrl) {
        Link savedLink = linkService.create(longUrl);
        return ResponseEntity.ok().body(savedLink);
    }

    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Link>> find() {
        List<Link> links = linkService.find();
        return ResponseEntity.ok().body(links);
    }
}
