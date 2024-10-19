package org.example.hexlet.repository;

import org.example.hexlet.model.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseRepository extends BaseRepository {
    public static void save(Course course) throws SQLException {
        String sql = "INSERT INTO courses (title, description) VALUES (?, ?);";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            var title = course.getTitle();
            var description = course.getDescription();

            preparedStatement.setString(1, title);
            preparedStatement.setString(2, description);
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                course.setId(generatedKeys.getLong("id"));
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
    }

    public static Optional<Course> findById(Long id) throws SQLException {
        String sql = "SELECT * FROM courses WHERE id = ?;";

        try (var conn = dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            var resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                var title = resultSet.getString("title");
                var description = resultSet.getString("description");
                var course = new Course(title, description);
                course.setId(id);
                return Optional.of(course);
            }
            return Optional.empty();
        }
    }

    public static Boolean existsByTitle(String title, Long id) {
        String sql = "SELECT * FROM courses WHERE title = ? AND id != ?;";

        try (var conn = dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, title);
            preparedStatement.setLong(2, id);
            var resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Course> getEntities() throws SQLException {

        String sql = "SELECT * FROM courses;";
        List<Course> courses = new ArrayList<>();

        try (var conn = dataSource.getConnection();
             var statement = conn.createStatement()) {
            var resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                var title = resultSet.getString("title");
                var description = resultSet.getString("description");
                var id = resultSet.getLong("id");

                var course = new Course(title, description);
                course.setId(id);
                courses.add(course);
            }
            return courses;
        }
    }

    public static List<Course> search(String term) throws SQLException {
        String sql = "SELECT * FROM courses WHERE title ILIKE ?;";
        List<Course> courses = new ArrayList<>();
        try (var conn = dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql)) {
            String searchPattern = term + "%";
            preparedStatement.setString(1, searchPattern);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                var title = resultSet.getString("title");
                var id = resultSet.getLong("id");

                var course = new Course(title, null);
                course.setId(id);
                courses.add(course);
            }
            return courses;
        }
    }

    public static void delete(Long id) throws SQLException {
        String sql = "DELETE FROM courses WHERE id = ?;";
        try (var conn = dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            var count = preparedStatement.executeUpdate();
            if (count != 1) {
                throw new SQLException("Course has not been deleted");
            }
        }
    }

    public static void update(Course course) throws SQLException {
        String sql = "UPDATE courses SET title = ?, description = ? WHERE id = ?;";

        try (var conn = dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql)) {

            var title = course.getTitle();
            var description = course.getDescription();
            var id = course.getId();

            preparedStatement.setString(1, title);
            preparedStatement.setString(2, description);
            preparedStatement.setLong(3, id);
            preparedStatement.executeUpdate();
        }
    }
}
