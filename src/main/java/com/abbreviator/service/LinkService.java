package com.abbreviator.service;

import com.abbreviator.entity.Link;

public interface LinkService {
    Link findLinkByAbbreviate(String abbreviate);

    Link save(Link link);
}
