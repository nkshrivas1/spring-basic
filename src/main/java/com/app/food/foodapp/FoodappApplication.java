package com.app.food.foodapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodapp","root","password");
//        PreparedStatement ps=
//                con.prepareStatement("INSERT INTO product VALUES(?,?,?)");
//        ps.setInt(1,1);
//        ps.setString(2,"Product Name");
//        ps.setString(3,"12345");
//        ps.executeUpdate();
//        ps.close();
//        con.close();
@SpringBootApplication
public class FoodappApplication {

    public static void main(String[] args) throws SQLException {


    }

}
