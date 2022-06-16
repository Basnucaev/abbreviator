package com.abbreviator.service.impl;

import com.abbreviator.entity.Link;
import com.abbreviator.repository.LinkRepository;
import com.abbreviator.service.ScheduledLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class ScheduledLinkServiceImpl implements ScheduledLinkService {
    private final LinkRepository linkRepository;

    @Autowired
    public ScheduledLinkServiceImpl(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    @Scheduled(fixedDelay = 5000)
    public void checkLinksTimeAndDeleteIfTimeHasCome() {
        ZoneId zoneId = ZoneId.of("Europe/Moscow");
        List<Link> links = linkRepository.findLinksByUsageTimeWasEnd(LocalDateTime.now(zoneId));

        if (links.size() > 0) {
            linkRepository.deleteAll(links);
        }
    }
}
