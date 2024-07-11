package com.manage.sml.smlAdminPage.repository;

import com.manage.sml.smlAdminPage.entity.EventLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface LogRepository extends JpaRepository<EventLog, Integer> {
    List<EventLog> findAllByActiveRegBetween(LocalDateTime startTime, LocalDateTime endTime);
}
