package org.example;

import java.sql.*;

public class App {
    private static final String jdbcURL = "jdbc:mysql://localhost/roblox";
    private static final String username = "root";
    private static final String password = "root"; // root

    private static final String createUser =
            "insert into users (username, user_level, currency, registration_date) value(?,?,?,?)";
    public static void main(String[] args) {

        createPlayer("timurTK30", 3, 8);
    }

    public static void createPlayer(String userName, int userLevel, int currency) {
        try {
            // Загрузка драйвера
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Конект с базой
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            // создание обьекта (делаем запрос)
            PreparedStatement preparedStatement = connection.prepareStatement(createUser);
            preparedStatement.setString(1, userName);
            preparedStatement.setInt(2, userLevel);
            preparedStatement.setInt(3, currency);
            preparedStatement.setDate(4, new Date(System.currentTimeMillis()));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
