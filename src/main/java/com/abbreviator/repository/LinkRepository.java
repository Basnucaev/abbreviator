package com.abbreviator.repository;

import com.abbreviator.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {
    Link findLinkByAbbreviated(String abbreviate);
}
