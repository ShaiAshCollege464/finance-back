package com.project.Utils;

import com.project.Objects.Entities.AnswerEntity;
import com.project.Objects.Entities.QuestionEntity;
import com.project.Objects.Entities.UserEntity;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public int insertUser(UserEntity userEntity) {
        String sql = "INSERT INTO users (name, phone) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, userEntity.getName());
            stmt.setString(2, userEntity.getPhone());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Inserting user failed, no rows affected.");
            }
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Inserting user failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public List<QuestionEntity> getAllQuestions() {
        List<QuestionEntity> questions = new ArrayList<>();
        String sql = "SELECT id, question, number FROM questions";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                QuestionEntity question = new QuestionEntity();
                question.setId(rs.getInt("id"));
                question.setQuestion(rs.getString("question"));
                question.setNumber(rs.getInt("number"));
                questions.add(question);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }

    public int insertAnswer(AnswerEntity answerEntity) {
        String sql = "INSERT INTO answers (user_id, question_id, answer) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, answerEntity.getUserId());
            stmt.setInt(2, answerEntity.getQuestionId());
            stmt.setString(3, answerEntity.getAnswer());

            int affectedRows = stmt.executeUpdate();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }


}
