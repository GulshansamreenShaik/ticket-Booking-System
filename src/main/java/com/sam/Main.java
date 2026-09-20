package com.sam;
import com.sam.util.DBConnection;
import java.sql.Connection;
import java.time.LocalDateTime;
import com.sam.model.Event;
import com.sam.dao.EventDAO;
import com.sam.dao.EventDAOImpl;
import java.util.List;

public class Main {
    // DATA BASE CONNECTION TEST

    // public static void main(String[] args) {
    //     try (Connection conn = DBConnection.getConnection()) {
    //         System.out.println("Connected to database successfully!");
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }

    // CREATING, SAVING and FINDING EVENT TEST

        public static void main(String args[]){
            try(Connection conn = DBConnection.getConnection()){
                EventDAO eventDAO = new EventDAOImpl(conn);
                Event event = new Event(0, "Opera", "Paris", LocalDateTime.of(2026, 12, 25, 19, 0), 150);
                eventDAO.save(event);
                
                List<Event> events =eventDAO.findAll();
                for(Event e: events){
                    System.out.println(e.getName());
                }
            }
            catch (Exception e) {
                e.printStackTrace();
         }

    }
}