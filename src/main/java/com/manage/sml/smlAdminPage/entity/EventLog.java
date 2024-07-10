package com.manage.sml.smlAdminPage.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "event_log")
public class EventLog {

    @Id
    @Column(name = "event_idx")
    private long eventIdx;

    @Column(name = "user_idx")
    private long userIdx;

    @Column(name = "active_type")
    private String activeType;

    @Column(name = "active_log")
    private LocalDateTime activeLog;

    public EventLog(long eventIdx, long userIdx, String activeType, LocalDateTime activeLog) {
        this.eventIdx = eventIdx;
        this.userIdx = userIdx;
        this.activeType = activeType;
        this.activeLog = activeLog;
    }

    public long getEventIdx() {
        return eventIdx;
    }

    public long getUserIdx() {
        return userIdx;
    }

    public String getActiveType() {
        return activeType;
    }

    public LocalDateTime getActiveLog() {
        return activeLog;
    }
}