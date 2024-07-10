package com.manage.sml.smlAdminPage.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_event_count")
public class UserEventCount {
    @Column (name = "count_idx")
    private int countIdx;

    @Column (name = "action")
    private String action;

    @Column (name = "chart_time")
    private LocalDateTime chartTime;

    @Column (name = "action_count")
    private int actionCount;

    public UserEventCount(int countIdx, String action, LocalDateTime chartTime, int actionCount) {
        this.countIdx = countIdx;
        this.action = action;
        this.chartTime = chartTime;
        this.actionCount = actionCount;
    }

    public UserEventCount(String action,LocalDateTime chartTime, int actionCount) {
        this.action = action;
        this.chartTime = chartTime;
        this.actionCount = actionCount;
    }

}
