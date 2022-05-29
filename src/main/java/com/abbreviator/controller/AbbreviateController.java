package com.abbreviator.controller;

import com.abbreviator.dao.RequestObjectLink;
import com.abbreviator.entity.Link;
import com.abbreviator.service.AbbreviateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AbbreviateController {
    private final AbbreviateService abbreviateService;

    @Autowired
    public AbbreviateController(AbbreviateService abbreviateService) {
        this.abbreviateService = abbreviateService;
    }

    @PostMapping("/abbreviate")
    public ResponseEntity<Link> abbreviateLink(@RequestBody RequestObjectLink requestObjectLink) {
        Link abbreviatedLink = abbreviateService.abbreviateURI(requestObjectLink);

        return new ResponseEntity<>(abbreviatedLink, HttpStatus.OK);
    }
}
