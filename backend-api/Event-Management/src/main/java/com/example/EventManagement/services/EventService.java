package com.example.EventManagement.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.EventManagement.dto.EventRequest;
import com.example.EventManagement.entities.Event;
import com.example.EventManagement.repositories.EventRepository;
import com.example.EventManagement.repositories.UserRepository;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Autowired
    public EventService(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    public List<Event> getAllEvents(@PathVariable long userID) {
        return eventRepository.getAllEvents(userID);
    }

    public void updateEvent(@PathVariable long userID, @PathVariable long eventID, @RequestBody EventRequest request) {
        Event eventToUpdate = eventRepository.findEvent(userID, eventID);
        eventToUpdate.setDescription(request.getDescription());
        eventToUpdate.setTitle(request.getTitle());
        eventToUpdate.setStartDate(request.getStartDate());
        eventToUpdate.setEndDate(request.getEndDate());
        eventRepository.save(eventToUpdate);
    }

    public Event addEvent(@PathVariable long userID, @RequestBody EventRequest request) {
        Event newEvent = new Event(request.getTitle(), request.getDescription(), request.getStartDate(), 
        request.getEndDate());
        newEvent.setUser(userRepository.getUser(userID));
        eventRepository.save(newEvent);
        return newEvent;
    }

    public void deleteEvent(@PathVariable long userID, @PathVariable long eventID) {
        Event eventToDelete = eventRepository.findEvent(userID, eventID);
        eventToDelete.setUser(null);
        eventRepository.delete(eventToDelete);
    }
    
}

