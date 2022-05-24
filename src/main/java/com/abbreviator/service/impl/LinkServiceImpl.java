package com.abbreviator.service.impl;

import com.abbreviator.entity.Link;
import com.abbreviator.exception.LinkNotFoundException;
import com.abbreviator.repository.LinkRepository;
import com.abbreviator.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements LinkService {
    private final LinkRepository linkRepository;
    private final String WEBSITE = "https://link-abbreviator.herokuapp.com/";

    @Autowired
    public LinkServiceImpl(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public Link findLinkByAbbreviate(String abbreviate) {
        Link link = linkRepository.findLinkByAbbreviated(WEBSITE + abbreviate);
        if (link != null) {
            return link;
        } else {
            throw new LinkNotFoundException();
        }
    }

    @Override
    public Link save(Link link) {
        linkRepository.save(link);
        return link;
    }
}
