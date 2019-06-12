package com.api.linkshortner.controller;

import com.api.linkshortner.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class RedirectController {
    private LinkService linkService;

    @Autowired
    public RedirectController(LinkService linkService) {
        this.linkService = linkService;
    }

    @RequestMapping(value = "{hash}", method = RequestMethod.GET)
    public void redirect(@PathVariable("hash") String hash, HttpServletResponse httpServletResponse) {
        String redirectUrl = linkService.findUrlByHash(hash);
        httpServletResponse.setHeader("Location", redirectUrl);
        httpServletResponse.setStatus(302);
    }
}
