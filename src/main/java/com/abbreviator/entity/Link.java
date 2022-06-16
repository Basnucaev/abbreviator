package com.abbreviator.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "link", indexes = {
        @Index(columnList = "abbreviated", name = "index_abbreviated", unique = true),
        @Index(columnList = "valid_until", name = "index_valid_until")}
)
@Getter
@Setter
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "link")
    private String link;

    @Column(name = "abbreviated")
    private String abbreviated;

    @Column(name = "date_of_create")
    private LocalDateTime dateOfCreate;

    @Column(name = "used_count")
    private int usedCount;

    @Column(name = "valid_until")
    private LocalDateTime validUntil;

    public Link() {
        this.dateOfCreate = LocalDateTime.now();
        this.validUntil = LocalDateTime.now().plusHours(24);
    }

    public Link(String link, String abbreviated) {
        this.link = link;
        this.abbreviated = abbreviated;
        this.dateOfCreate = LocalDateTime.now();
        this.validUntil = LocalDateTime.now().plusHours(24);
    }
}
