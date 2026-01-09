package com.app.food.foodapp;

import com.app.food.foodapp.config.AppConfig;
import com.app.food.foodapp.dao.InventoryDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

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
        AnnotationConfigApplicationContext ctx=
                new AnnotationConfigApplicationContext(AppConfig.class);
        JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
        InventoryDao idao = new InventoryDao(jdbcTemplate);
//        idao.save();

    }

}
