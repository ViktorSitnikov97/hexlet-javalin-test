package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.dto.courses.CoursesPage;

import static io.javalin.rendering.template.TemplateUtil.model;


public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> ctx.render("index.jte"));
        app.get("/courses", ctx -> {
            var courses = Data.getCourses();
            var header = "курсы по программированию";
            var page = new CoursesPage(courses, header);
            ctx.render("courses/index.jte", model("page", page));

        });

        app.get("/courses/{id}", ctx -> {
            var id = ctx.pathParam("id");
            var course = Data.getCourses().stream()
                    .filter(c -> c.getId().toString().equals(id))
                    .findFirst()
                    .orElseThrow(NotFoundResponse::new);
            var page = new CoursesPage(course);
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
