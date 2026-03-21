package com.lrrent.backend.repository;

import com.lrrent.backend.entity.Auto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoRepository extends JpaRepository<Auto, Long> {
}