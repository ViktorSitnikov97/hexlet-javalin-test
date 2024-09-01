package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import org.apache.commons.lang3.StringUtils;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;
import org.example.hexlet.util.Security;

import java.util.List;
import java.util.Objects;

import static io.javalin.rendering.template.TemplateUtil.model;


public class App {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> ctx.render("index.jte"));

        app.get("/users", ctx -> {
            var term = ctx.queryParam("term");
            List<User> users;
            if (term != null) {
                users = UserRepository.search(term);
            } else {
                users = UserRepository.getEntities();
            }

            var page = new UsersPage(users, term);
            ctx.render("users/index.jte", model("page", page));
        });

        app.get("/users/build", ctx -> {
            ctx.render("users/build.jte");
        });
        app.post("/users", ctx -> {
            var name = StringUtils.capitalize(ctx.formParam("name").trim());
            var email = ctx.formParam("email").trim().toLowerCase();
            var password = ctx.formParam("password");
            var encryptedPassword = Security.encrypt(password);
            var passwordConfirmation = ctx.formParam("passwordConfirmation");

            var user = new User(name, email, passwordConfirmation);
            UserRepository.save(user);
            ctx.redirect("/users");
        });

        app.get("/users/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            var user = UserRepository.find(id).get();
            var page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        });

        app.get("/courses", ctx -> {
            var term = ctx.queryParam("term");
            List<Course> courses;
            if (term != null) {
                courses = CourseRepository.search(term);
            } else {
                courses = CourseRepository.getEntities();
            }

            var page = new CoursesPage(courses, term);
            ctx.render("courses/index.jte", model("page", page));
        });

        app.get("courses/build", ctx -> {
            ctx.render("courses/build.jte");
        });
        app.post("/courses", ctx -> {
            var name = StringUtils.capitalize(ctx.formParam("name").trim());
            var description = ctx.formParam("description");

            var course = new Course(name, description);
            CourseRepository.save(course);
            ctx.redirect("/courses");
        });

        app.get("/courses/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            var course = CourseRepository.find(id).get();
            var page = new CoursePage(course);
            ctx.render("courses/show.jte", model("page", page));
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
