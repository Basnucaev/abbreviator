package com.abbreviator.repository;

import com.abbreviator.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {
    Link findLinkByAbbreviated(String abbreviate);

    @Query("from Link link where link.validUntil < current_date")
    List<Link> findLinksByUsageTimeWasEnd();
}
