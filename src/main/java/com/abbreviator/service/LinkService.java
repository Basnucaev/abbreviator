package com.abbreviator.service;

import com.abbreviator.entity.Link;

import java.util.List;

public interface LinkService {
    Link findLinkByAbbreviate(String abbreviate);

    Link save(Link link);

    List<Link> getAllLinks();
}
