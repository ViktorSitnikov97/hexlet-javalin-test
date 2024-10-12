package org.example.hexlet.controllers;

import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import org.example.hexlet.dto.MainPage;
import org.example.hexlet.util.NamedRoutes;

import static io.javalin.rendering.template.TemplateUtil.model;

public class SessionController {

    public static void build(Context ctx) {
        var visited = Boolean.valueOf(ctx.cookie("visited4"));
        var page = new MainPage(visited, null, null);
        ctx.render("sessions/build.jte", model("page", page));
    }

    public static void create(Context ctx) {
        var nickname = ctx.formParamAsClass("nickname", String.class).get();
        try {
            var passwordConfirmation = ctx.formParam("passwordConfirmation");
            var password = ctx.formParamAsClass("password", String.class)
                    .check(value -> value.equals(passwordConfirmation), "Пароли не совпадают")
                    .check(value -> value.length() >= 4, "Пароль менее 4 символов")
                    .get();
            ctx.sessionAttribute("currentUser", nickname);
            ctx.redirect(NamedRoutes.rootPath());
        } catch(ValidationException e) {
            var visited = Boolean.valueOf(ctx.cookie("visited4"));
            var page = new MainPage(visited, null, e.getErrors());
            ctx.render("sessions/build.jte", model("page", page));
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }

}
