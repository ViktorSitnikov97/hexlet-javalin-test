package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;

import java.util.Objects;

import static io.javalin.rendering.template.TemplateUtil.model;


public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> ctx.render("index.jte"));

        app.get("/users", ctx -> {
            var users = Data.getUsers();
            var page = new UsersPage(users);
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
