package edu.javacourse.city.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionBuilder {

//    public ConnectionBuilder() {
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

     Connection getConnection() throws SQLException ;
}
