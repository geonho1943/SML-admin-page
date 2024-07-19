package com.manage.sml.smlAdminPage.controller.chart;

import com.manage.sml.smlAdminPage.entity.PlaylistEventCount;
import com.manage.sml.smlAdminPage.service.playlist.PlaylistChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/chart/playlists")
public class PlaylistChartController {

    @Autowired
    PlaylistChartService playlistChartService;

    @GetMapping("/check-count/hour")
    public List<PlaylistEventCount> getCheckCountInfoByHour(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return playlistChartService.getCheckCountByHour(startTime, endTime);
    }

    @GetMapping("/create-count/hour")
    public List<PlaylistEventCount> getCreateCountInfoByHour(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return playlistChartService.getCreateCountByHour(startTime, endTime);
    }
    @GetMapping("/delete-count/hour")
    public List<PlaylistEventCount> getDeleteCountInfoByHour(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return playlistChartService.getDeleteCountByHour(startTime, endTime);
    }
    @GetMapping("/deactivate-count/hour")
    public List<PlaylistEventCount> getDeactivateCountInfoByHour(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return playlistChartService.getDeactivateCountByHour(startTime, endTime);
    }
}
