package com.manage.sml.smlAdminPage.service.playlist;

import com.manage.sml.smlAdminPage.entity.PlaylistEventCount;
import com.manage.sml.smlAdminPage.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PlaylistChartService {

    @Autowired
    private PlaylistRepository playlistRepository;

    public List<PlaylistEventCount> getCheckCountByHour(LocalDateTime startTime, LocalDateTime endTime) {
        return playlistRepository.findByActionAndChartTimeBetween("check", startTime, endTime);
    }

    public List<PlaylistEventCount> getCreateCountByHour(LocalDateTime startTime, LocalDateTime endTime) {
        return playlistRepository.findByActionAndChartTimeBetween("create", startTime, endTime);
    }

    public List<PlaylistEventCount> getDeleteCountByHour(LocalDateTime startTime, LocalDateTime endTime) {
        return playlistRepository.findByActionAndChartTimeBetween("delete", startTime, endTime);
    }

    public List<PlaylistEventCount> getDeactivateCountByHour(LocalDateTime startTime, LocalDateTime endTime) {
        return playlistRepository.findByActionAndChartTimeBetween("deactivate", startTime, endTime);
    }
}