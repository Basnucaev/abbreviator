package com.abbreviator.service.impl;

import com.abbreviator.entity.Link;
import com.abbreviator.exception.LinkNotFoundException;
import com.abbreviator.repository.LinkRepository;
import com.abbreviator.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

        if (link != null
                && !isAllUsagesHasSpent(link)
                && !isLinkUsageTimeHasPassed(link)) {

            link.setUsedCount(link.getUsedCount() + 1);
            return save(link);
        } else {
            throw new LinkNotFoundException();
        }
    }

    @Override
    public Link save(Link link) {
        linkRepository.save(link);
        return link;
    }

    @Override
    public List<Link> getAllLinks() {
        return linkRepository.findAll();
    }

    private boolean isAllUsagesHasSpent(Link link) {
        if (link.getUsedCount() >= 5) {
            linkRepository.delete(link);
            return true;
        } else {
            return false;
        }
    }

    private boolean isLinkUsageTimeHasPassed(Link link) {
        if (link.getValidUntil().isBefore(LocalDateTime.now())) {
            linkRepository.delete(link);
            return true;
        } else {
            return false;
        }
    }
}
