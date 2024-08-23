package org.example.hexlet.dto.courses;

import lombok.Getter;
import org.example.hexlet.model.Course;

import java.util.List;


@Getter
public class CoursesPage {
    private List<Course> courses;
    private String header;
    private Course course;

    public CoursesPage(List<Course> courses, String header) {
        this.courses = courses;
        this.header = header;
    }

    public CoursesPage(Course course) {
        this.course = course;
    }
}
