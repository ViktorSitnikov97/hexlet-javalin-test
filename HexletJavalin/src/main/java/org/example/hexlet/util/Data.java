package org.example.hexlet.util;

import net.datafaker.Faker;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Data {
    private static final int ITEMS_COUNT = 30;

    public static List<List<String>> getUsers() {
        Random random = new Random(123);
        Faker faker = new Faker(new Locale("en"), random);
        List<List<String>> users = new ArrayList<>();

        for (int i = 0; i < ITEMS_COUNT; i++) {
            List<String> user = new ArrayList<>();
            user.add(faker.twitter().userName());
            user.add(faker.internet().emailAddress());
            user.add(faker.internet().password());
            users.add(user);
        }

        return users;
    }
}
