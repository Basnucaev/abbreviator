package com.abbreviator.controller;

import com.abbreviator.dao.RequestObjectLink;
import com.abbreviator.entity.Link;
import com.abbreviator.service.AbbreviateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Abbreviate Controller", description = "Контроллер отвечающий за сокращение ссылок")
public class AbbreviateController {
    private final AbbreviateService abbreviateService;

    @Autowired
    public AbbreviateController(AbbreviateService abbreviateService) {
        this.abbreviateService = abbreviateService;
    }

    @Operation(summary = "Сокращает ссылку которая передается в dto объекте с единственным полем link")
    @PostMapping("/abbreviate")
    public ResponseEntity<Link> abbreviateLink(@RequestBody RequestObjectLink requestObjectLink) {
        Link abbreviatedLink = abbreviateService.abbreviateURI(requestObjectLink);

        return new ResponseEntity<>(abbreviatedLink, HttpStatus.OK);
    }
}
