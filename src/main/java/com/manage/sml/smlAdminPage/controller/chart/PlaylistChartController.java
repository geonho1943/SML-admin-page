package com.manage.sml.smlAdminPage.controller.chart;

import com.manage.sml.smlAdminPage.entity.PlaylistEventCount;
import com.manage.sml.smlAdminPage.service.playlist.PlaylistChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("chart-info")
public class PlaylistChartController {

    @Autowired
    PlaylistChartService playlistChartService;

    @GetMapping("/allPlaylistCheckCountByHour")
    public List<PlaylistEventCount> getCheckCountInfoByHour() {
        //모든 플레이리스트의 시간당 조회된 횟수
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return playlistChartService.getCheckCountByHour(startTime, endTime);
    }

    @GetMapping("/allPlaylistCreateCountByHour")
    public List<PlaylistEventCount> getCreateCountInfoByHour() {
        //모든 플레이리스트의 시간당 조회된 횟수
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return playlistChartService.getCreateCountByHour(startTime, endTime);
    }
    @GetMapping("/allPlaylistDeleteCountByHour")
    public List<PlaylistEventCount> getDeleteCountInfoByHour() {
        //모든 플레이리스트의 시간당 조회된 횟수
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return playlistChartService.getDeleteCountByHour(startTime, endTime);
    }
    @GetMapping("/allPlaylistDeactivateCountByHour")
    public List<PlaylistEventCount> getDeactivateCountInfoByHour() {
        //모든 플레이리스트의 시간당 조회된 횟수
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusDays(1);
        return playlistChartService.getDeactivateCountByHour(startTime, endTime);
    }
}
