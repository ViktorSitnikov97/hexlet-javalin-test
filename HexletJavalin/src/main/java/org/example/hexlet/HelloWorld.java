package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

import static io.javalin.rendering.template.TemplateUtil.model;


public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> ctx.render("index.jte"));

        app.get("/users", ctx -> {
            var term = ctx.queryParam("term");
            ArrayList<User> users;
            if (term != null) {
                users = Data.getUsers().stream()
                        .filter(u -> u.getFirstName().toLowerCase().contains(term.toLowerCase().trim())
                                || u.getLastName().toLowerCase().contains(term.toLowerCase().trim())
                        )
                        .collect(Collectors.toCollection(ArrayList::new));
            } else {
                users = Data.getUsers().stream()
                        .sorted(Comparator.comparing(User::getFirstName))
                        .collect(Collectors.toCollection(ArrayList::new));
            }
            var page = new UsersPage(users, term);
            ctx.render("users/index.jte", model("page", page));
        });

        app.get("/users/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            var user = Data.getUsers().stream()
                    .filter(u -> Objects.equals(u.getId(), id))
                    .findFirst()
                    .orElseThrow(NotFoundResponse::new);
            var page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        });

        app.get("/hello", ctx -> {
            var name = ctx.queryParam("name");
            if (name != null) {
                ctx.result(String.format("Hello, %s!", name));
            } else {
                ctx.result("Hello, World!");
            }

        });
        app.start(7070);
    }
}
