package com.project.Utils;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.*;

@Component
public class DbUtils {

    private static final String USER = "root";
    private static final String PASSWORD = "1234";
    private static final String SCHEMA_NAME = "project";
    private static final String URL = "jdbc:mysql://localhost:3306/" + SCHEMA_NAME + "?useSSL=false&serverTimezone=UTC";

    private Connection connection;

    @PostConstruct
    public void init() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connection established successfully.");
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
//
//    public List<User> getAllUsers() {
//        List<User> users = new ArrayList<>();
//        String sql = "SELECT id, name, email FROM user";
//        try (PreparedStatement stmt = connection.prepareStatement(sql);
//             ResultSet rs = stmt.executeQuery()) {
//            while (rs.next()) {
//                User user = new User();
//                user.setId(rs.getInt("id"));
//                user.setName(rs.getString("name"));
//                user.setEmail(rs.getString("email"));
//                users.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace()
//        }
//        return users;
//    }

//    public void insertUser(User user) {
//        String sql = "INSERT INTO user (name, email) VALUES (?, ?)";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, user.getName());
//            stmt.setString(2, user.getEmail());
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace(); // Replace with proper logging
//        }
//    }


//

}
