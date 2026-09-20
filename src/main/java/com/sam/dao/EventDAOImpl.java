package com.sam.dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.sam.model.Event;


public class EventDAOImpl implements EventDAO {
  private Connection conn; // dependency
  public EventDAOImpl(Connection conn){
    this.conn = conn; //injection
  }

  @Override
  public Event findById(int id){
    String sql = "SELECT * FROM events WHERE id = ?";
    try (PreparedStatement ps = conn.prepareStatement(sql)){
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()){
        int eventId = rs.getInt("id");
        String name = rs.getString("name");
        int totalSeats = rs.getInt("total_seats");
        String venue = rs.getString("venue");
        LocalDateTime eventDate = rs.getObject("event_date",LocalDateTime.class);
        return new Event(eventId, name, venue, eventDate, totalSeats);
      }
    }
    catch(SQLException e){
      e.printStackTrace();
    }
    return null;
  }


  @Override
  public List<Event> findAll(){
    String sql = "SELECT * FROM events";
    List<Event> eventList = new ArrayList<>();
    try(PreparedStatement ps = conn.prepareStatement(sql)){
      ResultSet rs = ps.executeQuery();
      while(rs.next()){
        int eventId = rs.getInt("id");
        String name = rs.getString("name");
        int totalSeats = rs.getInt("total_seats");
        String venue = rs.getString("venue");
        LocalDateTime eventDate = rs.getObject("event_date",LocalDateTime.class);
        eventList.add(new Event(eventId, name, venue, eventDate, totalSeats));
        }
      }
      catch(SQLException e){
      e.printStackTrace();
      }
    return eventList;
  }
  @Override
    public List<Event> findUpcomingEvents(LocalDateTime fromDate) {
      String sql = "SELECT * FROM events WHERE event_date >= ?";
      List<Event> eventList = new ArrayList<>();
      try(PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setObject(1, fromDate);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
          int eventId = rs.getInt("id");
        String name = rs.getString("name");
        int totalSeats = rs.getInt("total_seats");
        String venue = rs.getString("venue");
        LocalDateTime eventDate = rs.getObject("event_date",LocalDateTime.class);
        eventList.add(new Event(eventId, name, venue, eventDate, totalSeats));
        }
      }
      catch(SQLException e){
        e.printStackTrace();
      }
        return eventList;
    }

  @Override
  public void save(Event event) {
    String sql = "INSERT INTO events(name, venue, event_date, total_seats) VALUES (?, ?, ?, ?)";
    try(PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, event.getName());
      ps.setString(2, event.getVenue());
      ps.setObject(3, event.getEventDate());
      ps.setInt(4, event.getTotalSeats());
      ps.executeUpdate();
      }
    catch(SQLException e){
      e.printStackTrace();
    }
  }
}
