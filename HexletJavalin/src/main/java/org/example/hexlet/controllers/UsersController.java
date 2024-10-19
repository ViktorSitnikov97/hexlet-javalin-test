package org.example.hexlet.controllers;

import io.javalin.validation.ValidationException;
import org.apache.commons.lang3.StringUtils;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.EditUserPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.UserRepository;

import io.javalin.http.Context;
import org.example.hexlet.util.NamedRoutes;

import java.sql.SQLException;
import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class UsersController {

    public static void index(Context ctx) throws SQLException {
        var term = ctx.queryParam("term");
        List<User> users;
        if (term != null) {
            users = UserRepository.search(term);
        } else {
            users = UserRepository.getEntities();
        }

        var page = new UsersPage(users, term);
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        page.setFlag(true);
        ctx.render("users/index.jte", model("page", page));
    }

    public static void show(Context ctx) throws Exception {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.findById(id).get();
        var page = new UserPage(user);
        ctx.render("users/show.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildUserPage();
        ctx.render("users/build.jte", model("page",page));
    }

    public static void create(Context ctx) throws SQLException {
        var name = StringUtils.capitalize(ctx.formParam("name").trim());

        try {
            var passwordConfirmation = ctx.formParam("passwordConfirmation");
            var password = ctx.formParamAsClass("password", String.class)
                    .check(value -> value.equals(passwordConfirmation), "Пароли не совпадают")
                    .check(value -> value.length() >= 4, "Пароль менее 4 символов")
                    .get();
            var emailCurrent = ctx.formParamAsClass("email", String.class)
                    .check(value -> !UserRepository.existsByEmail(normalizeEmail(value), 0L), "Пользователь с такой почтой уже существует")
                    .get();
            var email = normalizeEmail(emailCurrent);
            var user = new User(name, email, password);
            UserRepository.save(user);
            ctx.sessionAttribute("flash", "User has been added!");
            ctx.redirect(NamedRoutes.usersPath());
        } catch (ValidationException e) {
            var page = new BuildUserPage(name, e.getErrors());
            ctx.sessionAttribute("flash", "User has not been added!");
            page.setFlash(ctx.consumeSessionAttribute("flash"));
            page.setFlag(false);
            ctx.render("users/build.jte", model("page", page));
        }
    }

    private static String normalizeEmail(String email) {
        return email.trim().toLowerCase();
    }

    public static void edit(Context ctx) throws Exception {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.findById(id).get();
        var name = user.getName();
        var email = user.getEmail();
        var page = new EditUserPage(id, name, email, null, null);
        ctx.render("users/edit.jte", model("page", page));
    }

    public static void update(Context ctx) throws Exception {

        var id = ctx.pathParamAsClass("id", Long.class).get();
        var name = StringUtils.capitalize(ctx.formParam("name").trim());
        var emailCurrent = ctx.formParam("email").trim().toLowerCase();

        try {
            var passwordConfirmation = ctx.formParam("passwordConfirmation");
            var password = ctx.formParamAsClass("password", String.class)
                    .check(value -> value.equals(passwordConfirmation), "Пароли не совпадают")
                    .check(value -> value.length() >= 4, "Пароль менее 4 символов")
                    .get();
            var email = normalizeEmail(ctx.formParamAsClass("email", String.class)
                    .check(value -> !UserRepository.existsByEmail(emailCurrent, id), "Такая почта уже используется")
                    .get());

            var user = UserRepository.findById(id).get();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            UserRepository.update(user);
            ctx.sessionAttribute("flash", "User has been updated!");
            ctx.redirect(NamedRoutes.usersPath());

        } catch (ValidationException e) {
//            var password = ctx.formParam("password");
            var page = new EditUserPage(id, name, emailCurrent, null, e.getErrors());
            ctx.sessionAttribute("flash","User has not been updated!");
            page.setFlash(ctx.consumeSessionAttribute("flash"));
            page.setFlag(false);
            ctx.render("users/edit.jte", model("page", page));
        }
    }

    public static void destroy(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        UserRepository.delete(id);
        ctx.sessionAttribute("flash", "User has been deleted!");
        ctx.redirect(NamedRoutes.usersPath());
    }

}
