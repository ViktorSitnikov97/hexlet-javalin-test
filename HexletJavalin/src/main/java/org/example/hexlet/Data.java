package org.example.hexlet;

import net.datafaker.Faker;
import org.example.hexlet.model.Course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.LongStream;


public class Data {

    private static final int ITEMS_COUNT = 30;
//    private static int idCounter = ITEMS_COUNT;

    public static List<Course> getCourses() {

        Random random = new Random(123);
        Faker faker = new Faker(new Locale("en"), random);

        List<Long> ids = new ArrayList<>(LongStream
                .range(1, ITEMS_COUNT + 1)
                .boxed()
                .toList());

        Collections.shuffle(ids, random);

        List<Course> courses = new ArrayList<>();

        for (int i = 1; i < ITEMS_COUNT; i++) {
            String name = faker.beer().name();
            String description = faker.beer().brand();
            Course course = new Course(name, description);
            course.setId(Long.valueOf(ids.get(i)));
            courses.add(course);
        }
        return courses;
    }
}
