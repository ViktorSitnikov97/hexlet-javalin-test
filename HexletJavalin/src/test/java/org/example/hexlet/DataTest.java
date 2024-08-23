package org.example.hexlet;

import org.example.hexlet.model.Course;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DataTest {

    @Test
    public void getDataTest() {
        List<Course> list = Data.getCourses();
        list.forEach(System.out::println);
    }
}
