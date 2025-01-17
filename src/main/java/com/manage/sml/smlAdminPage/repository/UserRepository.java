package com.manage.sml.smlAdminPage.repository;

import com.manage.sml.smlAdminPage.entity.UserEventCount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface UserRepository extends JpaRepository<UserEventCount, Integer> {
    List<UserEventCount> findByActionAndChartTimeBetween(String action, LocalDateTime startTime, LocalDateTime endTime);

}
