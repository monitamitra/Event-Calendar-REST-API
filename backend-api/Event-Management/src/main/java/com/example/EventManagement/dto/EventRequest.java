package com.example.EventManagement.dto;

import java.sql.Date;

public class EventRequest {
    private String description;

    public String getDescription() {
        return this.description;
    }

    private String title;

    public String getTitle() {
        return this.title;
    }

    private Date startDate;

    public Date getStartDate() {
        return this.startDate;
    }

    private Date endDate;

    public Date getEndDate() {
        return this.endDate;
    }
}
