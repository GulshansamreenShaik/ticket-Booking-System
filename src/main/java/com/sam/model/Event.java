package com.sam.model;
import java.time.LocalDateTime;

public class Event {
  private int id;
  private String name;
  private String venue;
  private LocalDateTime eventDate;
  private int totalSeats;
  public Event(int id,String name, String venue,LocalDateTime eventDate, int totalSeats){
    this.id=id;
    this.name=name;
    this.venue=venue;
    this.eventDate= eventDate;
    this.totalSeats=totalSeats;
    
  }
  public int getId() {
  return this.id;
}
  public void setId(int id) {
      this.id = id;
  }

  public String getName() {
      return this.name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public String getVenue() {
      return this.venue;
  }

  public void setVenue(String venue) {
      this.venue = venue;
  }

  public LocalDateTime getEventDate() {
      return this.eventDate;
  }

  public void setEventDate(LocalDateTime eventDate) {
      this.eventDate = eventDate;
  }

  public int getTotalSeats() {
      return this.totalSeats;
  }

  public void setTotalSeats(int totalSeats) {
      if (totalSeats < 0) {
          throw new IllegalArgumentException("Seats cannot be negative");
      }
      this.totalSeats = totalSeats;
  }
}
