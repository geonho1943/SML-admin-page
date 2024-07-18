package com.manage.sml.smlAdminPage.repository;

import com.manage.sml.smlAdminPage.entity.CardEventCount;
import com.manage.sml.smlAdminPage.entity.UserEventCount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CardRepository extends JpaRepository<CardEventCount, Integer> {
    List<CardEventCount> findByActionAndChartTimeBetween(String action, LocalDateTime startTime, LocalDateTime endTime);

}
