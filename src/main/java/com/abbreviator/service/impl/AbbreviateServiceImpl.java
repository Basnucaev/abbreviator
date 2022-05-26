package com.abbreviator.service.impl;

import com.abbreviator.controller.help.RequestObjectLink;
import com.abbreviator.entity.Link;
import com.abbreviator.service.AbbreviateService;
import com.abbreviator.service.LinkService;
import com.abbreviator.service.help.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbbreviateServiceImpl implements AbbreviateService {
    private final LinkService linkService;
    private final String WEBSITE = "https://link-abbreviator.herokuapp.com/";

    @Autowired
    public AbbreviateServiceImpl(LinkService linkService) {
        this.linkService = linkService;
    }

    @Override
    public Link abbreviateURI(RequestObjectLink link) {
        String linkString = link.getLink();
        String assignedLink = addHttpsToTheBeginningIfIsNotHere(linkString);

        RandomString randomString = new RandomString(4);
        String abbreviated = WEBSITE + randomString.getRandomString();

        return linkService.save(new Link(assignedLink, abbreviated));
    }

    private String addHttpsToTheBeginningIfIsNotHere(String uri) {
        if (uri.contains("https://") || uri.contains("http://")) {
            return uri;
        } else {
            return "https://" + uri;
        }
    }
}
