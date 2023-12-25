package com.example.EventManagement.entities;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "EVENTS")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EVENT_ID")
    private long ID;

    public long getID() {
        return this.ID;
    }

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "USER_ID")
    private User user;

    public User getUser() {
        return this.user;
    }

    public void setUser(User updatedUser) {
        this.user = updatedUser;
    }

    private String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String updatedDescription) {
        this.description = updatedDescription;
    }

    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String updatedTitle) {
        this.title = updatedTitle;
    }

    private Date startDate;

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date updatedStartDate) {
        this.startDate = updatedStartDate;
    }

    private Date endDate;

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date updatedEndDate) {
        this.endDate = updatedEndDate;
    }

    public Event() {

    }

    public Event(String title, String description, Date startDate, Date endDate) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
