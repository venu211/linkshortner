package com.api.linkshortner.repository;

import com.api.linkshortner.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
    public Link findByHash(String hash);
    public Link findByUrl(String url);
}
