package org.example.hexlet;

import net.datafaker.Faker;
import org.example.hexlet.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.LongStream;


public class Data {

    private static final int ITEMS_COUNT = 30;
//    private static int idCounter = ITEMS_COUNT;

    public static List<User> getUsers() {

        Random random = new Random(123);
        Faker faker = new Faker(new Locale("en"), random);

        List<Long> ids = new ArrayList<>(LongStream
                .range(1, ITEMS_COUNT + 1)
                .boxed()
                .toList());

        Collections.shuffle(ids, random);

        List<User> users = new ArrayList<>();

        for (int i = 1; i < ITEMS_COUNT; i++) {
            Long id = ids.get(i);
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = faker.internet().emailAddress();
            User user = new User(id, firstName, lastName, email);
            users.add(user);
        }
        return users;
    }
}
