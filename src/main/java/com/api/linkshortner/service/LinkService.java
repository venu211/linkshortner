package com.api.linkshortner.service;

import com.api.linkshortner.model.Link;

import java.util.List;

public interface LinkService {
    Link create(String url);
    List<Link> find();
    String findUrlByHash(String hash);
}



