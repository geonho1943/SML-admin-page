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

    @GetMapping("/check-count/day")
    public List<PlaylistEventCount> getCheckCountInfoByDay(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return playlistChartService.getPlaylistCountByDay("check", startTime, endTime);
    }

    @GetMapping("/create-count/day")
    public List<PlaylistEventCount> getCreateCountInfoByDay(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return playlistChartService.getPlaylistCountByDay("create", startTime, endTime);
    }
    @GetMapping("/delete-count/day")
    public List<PlaylistEventCount> getDeleteCountInfoByDay(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return playlistChartService.getPlaylistCountByDay("delete", startTime, endTime);
    }
    @GetMapping("/deactivate-count/day")
    public List<PlaylistEventCount> getDeactivateCountInfoByDay(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return playlistChartService.getPlaylistCountByDay("deactivate", startTime, endTime);
    }

    @GetMapping("/check-count/week")
    public List<PlaylistEventCount> getCheckCountInfoByWeek(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusWeeks(1);
        return playlistChartService.getPlaylistCountByWeek("check", startTime, endTime);
    }

    @GetMapping("/create-count/week")
    public List<PlaylistEventCount> getCreateCountInfoByWeek(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusWeeks(1);
        return playlistChartService.getPlaylistCountByWeek("create", startTime, endTime);
    }
    @GetMapping("/delete-count/week")
    public List<PlaylistEventCount> getDeleteCountInfoByWeek(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusWeeks(1);
        return playlistChartService.getPlaylistCountByWeek("delete", startTime, endTime);
    }
    @GetMapping("/deactivate-count/week")
    public List<PlaylistEventCount> getDeactivateCountInfoByWeek(
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endTime) {
        if (endTime == null) endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusWeeks(1);
        return playlistChartService.getPlaylistCountByWeek("deactivate", startTime, endTime);
    }
}
