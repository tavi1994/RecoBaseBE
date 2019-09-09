package com.qa.repository;

import com.qa.models.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordsRepository
        extends JpaRepository<Record, Long> {
}



