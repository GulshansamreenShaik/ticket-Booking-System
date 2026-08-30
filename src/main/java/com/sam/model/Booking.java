package com.sam.model;
import java.time.LocalDateTime;

public class Booking {
  
  public enum BookingStatus {
    CONFIRMED, CANCELLED
  }
  private int id;
  private int userId;
  private int eventId;
   private int seatId;
  private BookingStatus status;
  private LocalDateTime bookedAt;
  public Booking(int id, int eventId,int userId,BookingStatus status, int seatId,LocalDateTime bookedAt) {
    this.id = id;
    this.userId = userId;
     this.seatId = seatId;
    this.eventId = eventId;
    this.bookedAt = bookedAt;
    this.status = status;
  }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSeatId() {
        return this.seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getEventId() {
        return this.eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public BookingStatus getStatus() {
        return this.status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public LocalDateTime getBookedAt() {
        return this.bookedAt;
    }

    public void setBookedAt(LocalDateTime bookedAt) {
        this.bookedAt = bookedAt;
    }
}

