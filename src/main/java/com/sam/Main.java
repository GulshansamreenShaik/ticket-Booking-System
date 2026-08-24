package com.sam;
import com.sam.util.DBConnection;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.println("Connected to database successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}