package com.example.EventManagement.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.EventManagement.entities.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long>{
    @Query("SELECT event FROM Event event WHERE event.user.Id = :userID")
    public List<Event> getAllEvents(long userID);

    @Query("SELECT event FROM Event event WHERE event.Id = :eventID AND event.user.Id = :userID")
    public Event findEvent(long userID, long eventID);
}
