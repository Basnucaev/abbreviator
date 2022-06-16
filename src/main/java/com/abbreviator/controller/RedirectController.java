package com.abbreviator.controller;

import com.abbreviator.entity.Link;
import com.abbreviator.service.LinkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Tag(name = "Redirect Controller", description = "Контроллер отвечающий за редирект по сокращенным ссылкам")
public class RedirectController {
    private final LinkService linkService;

    @Autowired
    public RedirectController(LinkService linkService) {
        this.linkService = linkService;
    }

    @Operation(summary = "Перенаправляет пользователя по его core ссылке")
    @RequestMapping("/{abbreviate}")
    public String goToRootSite(@PathVariable String abbreviate) {
        Link link = linkService.findLinkByAbbreviate(abbreviate);

        return "redirect:" + link.getLink();
    }
}
