package com.manage.sml.smlAdminPage.service.playlist;

import com.manage.sml.smlAdminPage.entity.PlaylistEventCount;

import com.manage.sml.smlAdminPage.repository.PlaylistRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PlaylistLogToCountConverter {

    @Autowired
    private PlaylistRepository playlistRepository;

    public void saveCheckCount(LocalDateTime endTime, int playlistCheck) {
        playlistRepository.save(new PlaylistEventCount("check", endTime, playlistCheck));
    }

    public void saveCreateCount(LocalDateTime endTime, int playlistCreate) {
        playlistRepository.save(new PlaylistEventCount("create", endTime, playlistCreate));
    }

    public void saveDeleteCount(LocalDateTime endTime, int playlistDelete) {
        playlistRepository.save(new PlaylistEventCount("delete", endTime, playlistDelete));
    }

    public void saveDeactiveCount(LocalDateTime endTime, int playlistDeactive) {
        playlistRepository.save(new PlaylistEventCount("deactive", endTime, playlistDeactive));
    }
}
