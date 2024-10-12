package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.controllers.CoursesController;
import org.example.hexlet.controllers.RootController;
import org.example.hexlet.controllers.SessionController;
import org.example.hexlet.controllers.UsersController;
import org.example.hexlet.util.NamedRoutes;



public class App {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get(NamedRoutes.rootPath(), RootController::indexRoot);

        app.get(NamedRoutes.buildSessionsPath(), SessionController::build);
        app.post(NamedRoutes.sessionsPath(), SessionController::create);
        app.get(NamedRoutes.deleteSessionsPath(), SessionController::destroy);

        app.get(NamedRoutes.usersPath(), UsersController::index);

        app.get(NamedRoutes.buildUserPath(), UsersController::build);
        app.post(NamedRoutes.usersPath(), UsersController::create);

        app.get(NamedRoutes.userPath("{id}"), UsersController::show);
        app.get(NamedRoutes.userEditPath("{id}"), UsersController::edit);
        app.post(NamedRoutes.userPath("{id}"), UsersController::update);

        app.get(NamedRoutes.userDeletePath("{id}"), UsersController::destroy);


        app.get(NamedRoutes.coursesPath(), CoursesController::index);

        app.get(NamedRoutes.buildCoursePath(), CoursesController::build);
        app.post(NamedRoutes.coursesPath(), CoursesController::create);

        app.get(NamedRoutes.coursePath("{id}"), CoursesController::show);
        app.get(NamedRoutes.courseEditPath("{id}"), CoursesController::edit);
        app.post(NamedRoutes.coursePath("{id}"), CoursesController::update);

        app.delete(NamedRoutes.coursePath("{id}"), CoursesController::destroy);


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
