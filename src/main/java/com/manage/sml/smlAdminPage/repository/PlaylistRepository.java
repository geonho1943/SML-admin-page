package com.manage.sml.smlAdminPage.repository;

import com.manage.sml.smlAdminPage.entity.PlaylistEventCount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PlaylistRepository extends JpaRepository<PlaylistEventCount, Integer> {
    List<PlaylistEventCount> findByActionAndChartTimeBetween(String action, LocalDateTime startTime, LocalDateTime endTime);

}
