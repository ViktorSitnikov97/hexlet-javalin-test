package org.example.hexlet.repository;

import io.javalin.http.NotFoundResponse;
import org.example.hexlet.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public final class UserRepository {
    private static final List<User> entities = new ArrayList<>();

    public static void save(User user) {
        user.setId((long) entities.size() + 1);
        entities.add(user);
    }

    public static void delete(Long id) {
        entities.remove(id.intValue());
    }

    public static List<User> search(String term) {
        return entities.stream()
                .filter(u -> u.getName().toLowerCase()
                        .contains(term.trim().toLowerCase()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static Optional<User> find(Long id) throws Exception {
        return Optional.ofNullable(entities.stream()
                .filter(u -> Objects.equals(u.getId(), id))
                .findFirst()
                .orElseThrow(() -> new Exception("User not found")));
    }

    public static List<User> getEntities() {
        return entities;
    }

}
