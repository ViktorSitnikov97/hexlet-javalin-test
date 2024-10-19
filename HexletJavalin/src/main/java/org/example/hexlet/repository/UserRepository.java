package org.example.hexlet.repository;


import org.example.hexlet.model.User;
import org.example.hexlet.util.Data;
import org.example.hexlet.util.Security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public final class UserRepository extends BaseRepository {

    public static void save(User user) throws SQLException {
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?);";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            var name = user.getName();
            var email = user.getEmail();
            var password = Security.encrypt(user.getPassword());

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                user.setId(generatedKeys.getLong("id"));
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
    }

    public static Optional<User> findById(Long id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?;";

        try (var conn = dataSource.getConnection();
                var preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            var resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                var name = resultSet.getString("name");
                var email = resultSet.getString("email");
                var password = resultSet.getString("password");
                var user = new User(name, email, password);
                user.setId(id);
                return Optional.of(user);
            }
            return Optional.empty();
        }
    }

    public static Boolean existsByEmail(String email, Long id) {
        String sql = "SELECT * FROM users WHERE email = ? AND id != ?;";

        try (var conn = dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            preparedStatement.setLong(2, id);
            var resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<User> getEntities() throws SQLException {

        String sql = "SELECT * FROM users;";
        List<User> users = new ArrayList<>();

        try (var conn = dataSource.getConnection();
                var statement = conn.createStatement()) {
            var resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                var name = resultSet.getString("name");
                var email = resultSet.getString("email");
                var id = resultSet.getLong("id");
                var password = resultSet.getString("password");

                var user = new User(name, email, password);
                user.setId(id);
                users.add(user);
            }
            return users;
        }
    }

    public static List<User> search(String term) throws SQLException {
        String sql = "SELECT * FROM users WHERE name ILIKE ?;";
        List<User> users = new ArrayList<>();
        try (var conn = dataSource.getConnection();
                var preparedStatement = conn.prepareStatement(sql)) {
            String searchPattern = term + "%";
            preparedStatement.setString(1, searchPattern);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                var name = resultSet.getString("name");
                var id = resultSet.getLong("id");

                var user = new User(name, null, null);
                user.setId(id);
                users.add(user);
            }
            return users;
        }
    }

    public static void delete(Long id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?;";
        try (var conn = dataSource.getConnection();
                var preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            var count = preparedStatement.executeUpdate();
            if (count != 1) {
                throw new SQLException("User has not been deleted");
            }
        }
    }

    public static void update(User user) throws SQLException {
        String sql = "UPDATE users SET name = ?, email = ?, password = ? WHERE id = ?;";

        try (var conn = dataSource.getConnection();
                var preparedStatement = conn.prepareStatement(sql)) {

            var name = user.getName();
            var email = user.getEmail();
            var password = user.getPassword();
            var id = user.getId();

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();
        }
    }

    public static void addFakeUsers() throws SQLException {
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?);";

        try (var conn = dataSource.getConnection();
                var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            List<List<String>> fakeUsers = Data.getUsers();

            for (var user : fakeUsers) {
                var name = user.get(0);
                var email = user.get(1);
                var password = Security.encrypt(user.get(2));

                preparedStatement.setString(1, name);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, password);
                preparedStatement.executeUpdate();
                var generatedKeys = preparedStatement.getGeneratedKeys();

                var currentUser = new User(name, email, password);
                if (generatedKeys.next()) {
                    currentUser.setId(generatedKeys.getLong("id"));
                } else {
                    throw new SQLException("DB have not returned an id after saving an entity");
                }
            }
        }
    }
}
