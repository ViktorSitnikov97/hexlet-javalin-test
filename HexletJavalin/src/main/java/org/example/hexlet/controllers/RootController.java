package org.example.hexlet.controllers;

import io.javalin.http.Context;
import org.example.hexlet.dto.MainPage;

import java.util.Objects;
import java.util.Optional;

import static io.javalin.rendering.template.TemplateUtil.model;

public class RootController {
    public static void indexRoot(Context ctx) {
        String currentUser = null;
        String flag = ctx.cookie("visited4");
        var visited = Boolean.valueOf(flag); // null -> false
        Optional<String> currentUserOpt = Optional.ofNullable(ctx.sessionAttribute("currentUser"));
        if (currentUserOpt.isPresent()) {
            currentUser = currentUserOpt.get();
        }
        var page = new MainPage(visited, currentUser, null);
        ctx.render("index.jte", model("page", page));
        ctx.cookie("visited4", String.valueOf(true));
    }
}
