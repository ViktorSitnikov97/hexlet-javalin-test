package org.example.hexlet.repository;

import org.example.hexlet.model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CourseRepository {
    private static final List<Course> entities = new ArrayList<>();

    public static void save(Course course) {
        course.setId((long) entities.size() + 1);
        entities.add(course);
    }

    public static List<Course> search(String term) {
        return entities.stream()
                .filter(entity -> entity.getName().toLowerCase()
                        .contains(term.trim().toLowerCase()))
                .toList();
    }

    public static Optional<Course> find(Long id) throws Exception {
        return Optional.ofNullable(entities.stream()
                .filter(entity -> Objects.equals(entity.getId(), id))
                .findAny()
                .orElseThrow(() -> new Exception("Course not found")));
    }

    public static List<Course> getEntities() {
        return entities;
    }
}
