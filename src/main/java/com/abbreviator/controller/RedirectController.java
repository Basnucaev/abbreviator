package com.abbreviator.controller;

import com.abbreviator.entity.Link;
import com.abbreviator.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
    private final LinkService linkService;

    @Autowired
    public RedirectController(LinkService linkService) {
        this.linkService = linkService;
    }

    @RequestMapping("/{abbreviate}")
    public String goToRootSite(@PathVariable String abbreviate) {
        Link link = linkService.findLinkByAbbreviate(abbreviate);

        return "redirect:" + link.getLink();
    }
}
