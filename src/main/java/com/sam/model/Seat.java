package com.sam.model;
import java.math.BigDecimal;

public class Seat {
  public enum SeatStatus{
    AVAILABLE,BOOKED
  }
  private int id;
  private int eventId;
  private String seatNumber;
  private SeatStatus status;
  private BigDecimal price;
  public Seat(int id, int eventId, String seatNumber, SeatStatus status, BigDecimal price) {
    this.id = id;
    this.eventId = eventId;
    this.seatNumber = seatNumber;
    this.status = status;
    this.price = price;
}

  public int getId() {
      return this.id;
  }

  public void setId(int id) {
      this.id = id;
  }

  public int getEventId() {
      return this.eventId;
  }

  public void setEventId(int eventId) {
      this.eventId = eventId;
  }

  public String getSeatNumber() {
      return this.seatNumber;
  }

  public void setSeatNumber(String seatNumber) {
      this.seatNumber = seatNumber;
  }

  public SeatStatus getStatus() {
      return this.status;
  }

  public void setStatus(SeatStatus status) {
      this.status = status;
  }
  public BigDecimal getPrice() {
      return this.price;
  }

  public void setPrice(BigDecimal price) {
      this.price = price;
  }
}
