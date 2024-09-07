package org.example.hexlet.controllers;

import io.javalin.validation.ValidationException;
import org.apache.commons.lang3.StringUtils;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.UserRepository;

import io.javalin.http.Context;
import org.example.hexlet.util.NamedRoutes;

import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class UsersController {

    public static void index(Context ctx) {
        var term = ctx.queryParam("term");
        List<User> users;
        if (term != null) {
            users = UserRepository.search(term);
        } else {
            users = UserRepository.getEntities();
        }

        var page = new UsersPage(users, term);
        ctx.render("users/index.jte", model("page", page));
    }

    public static void show(Context ctx) throws Exception {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id).get();
        var page = new UserPage(user);
        ctx.render("users/show.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildUserPage();
        ctx.render("users/build.jte", model("page",page));
    }

    public static void create(Context ctx) {
        var name = StringUtils.capitalize(ctx.formParam("name").trim());
        var email = ctx.formParam("email").trim().toLowerCase();

        try{
            var passwordConfirmation = ctx.formParam("passwordConfirmation");
            var password = ctx.formParamAsClass("password", String.class)
                    .check(value -> value.equals(passwordConfirmation), "Пароли не совпадают")
                    .check(value -> value.length() >= 6, "Пароль менее 6 символов")
                    .get();
            var user = new User(name, email, password);
            UserRepository.save(user);
            ctx.redirect(NamedRoutes.usersPath());
        } catch(ValidationException e) {
            var page = new BuildUserPage(name, email, e.getErrors());
            ctx.render("users/build.jte", model("page", page));
        }
    }

    public static void edit(Context ctx) throws Exception {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id).get();
        var page = new UserPage(user);
        ctx.render("users/edit.jte", model("page", page));
    }

    public static void update(Context ctx) throws Exception {
        var id = ctx.pathParamAsClass("id", Long.class).get();

        var name = StringUtils.capitalize(ctx.formParam("name").trim());
        var email = ctx.formParam("email").trim().toLowerCase();

        try{
            var passwordConfirmation = ctx.formParam("passwordConfirmation");
            var password = ctx.formParamAsClass("password", String.class)
                    .check(value -> value.equals(passwordConfirmation), "Пароли не совпадают")
                    .check(value -> value.length() >= 6, "Пароль менее 6 символов")
                    .get();

            var user = UserRepository.find(id).get();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);

            ctx.redirect(NamedRoutes.usersPath());

        } catch(ValidationException e) {
            var page = new BuildUserPage(name, email, e.getErrors());
            ctx.render("users/edit.jte", model("page", page));
        }
    }

    public static void destroy(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        UserRepository.delete(id);
        ctx.redirect(NamedRoutes.usersPath());
    }

}
