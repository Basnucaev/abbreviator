package com.abbreviator.controller;

import com.abbreviator.entity.Link;
import com.abbreviator.service.LinkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Link Controller", description = "Контроллер отвечающий за CRUD операции с ссылками (пока недоработан)")
public class LinkController {
    private final LinkService linkService;

    @Autowired
    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @Operation(summary = "Возвращает все ссылки")
    @GetMapping("/links")
    public ResponseEntity<List<Link>> getAllLinks() {
        return new ResponseEntity<>(linkService.getAllLinks(), HttpStatus.OK);
    }
}
