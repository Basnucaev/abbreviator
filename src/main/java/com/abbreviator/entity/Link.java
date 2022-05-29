package com.abbreviator.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "link")
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

    public Link() {
        this.dateOfCreate = LocalDateTime.now();
    }

    public Link(String link, String abbreviated) {
        this.link = link;
        this.abbreviated = abbreviated;
        this.dateOfCreate = LocalDateTime.now();
    }
}
