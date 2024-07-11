package com.manage.sml.smlAdminPage.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_event_count")
public class UserEventCount {

    @Id
    @Column (name = "count_idx")
    private int countIdx;

    @Column (name = "action")
    private String action;

    @Column (name = "chart_time")
    private LocalDateTime chartTime;

    @Column (name = "active_count")
    private int activeCount;

    public UserEventCount(int countIdx, String action, LocalDateTime chartTime, int activeCount) {
        this.countIdx = countIdx;
        this.action = action;
        this.chartTime = chartTime;
        this.activeCount = activeCount;
    }

    public UserEventCount(String action,LocalDateTime chartTime, int activeCount) {
        this.action = action;
        this.chartTime = chartTime;
        this.activeCount = activeCount;
    }

}
