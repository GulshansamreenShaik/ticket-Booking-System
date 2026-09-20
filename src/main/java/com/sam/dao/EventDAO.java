package com.sam.dao;
import com.sam.model.Event;

import java.time.LocalDateTime;
import java.util.List;

public interface EventDAO {
    Event findById(int id);
    List<Event> findAll();
    List<Event> findUpcomingEvents(LocalDateTime fromDate);
    void save (Event event);
}
