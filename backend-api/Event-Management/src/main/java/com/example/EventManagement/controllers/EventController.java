package com.example.EventManagement.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.EventManagement.dto.EventRequest;
import com.example.EventManagement.services.EventService;
import com.example.EventManagement.entities.Event;

@RestController
@CrossOrigin("http://localhost:3000")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/api/{userID}/events")
    public List<Event> getAllEvents(@PathVariable long userID) {
        return eventService.getAllEvents(userID);
    }

    @PutMapping("/api/{userID}/events/{eventID}")
    public void updateEvent(@PathVariable long userID, @PathVariable Long eventID, @RequestBody EventRequest request) {
        eventService.updateEvent(userID, eventID, request);
    }

    @DeleteMapping("/api/{userID}/events/delete/{eventID}")
    public void deleteEvent(@PathVariable long userID, @PathVariable long eventID) {
        eventService.deleteEvent(userID, eventID);
    }

    @PostMapping("/api/{userID}/events/create")
    public Event addEvent(@PathVariable long userID, @RequestBody EventRequest request) {
        return eventService.addEvent(userID, request);
    }
}
