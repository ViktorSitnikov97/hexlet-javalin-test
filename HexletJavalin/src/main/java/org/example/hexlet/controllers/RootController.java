package org.example.hexlet.controllers;

import io.javalin.http.Context;
import org.example.hexlet.dto.MainPage;

import static io.javalin.rendering.template.TemplateUtil.model;

public class RootController {
    public static void indexRoot(Context ctx) {
        String flag = ctx.cookie("visited4");
        var visited = Boolean.valueOf(flag); // null -> false
        var page = new MainPage(visited);
        ctx.render("index.jte", model("page", page));
        ctx.cookie("visited4", String.valueOf(true));
    }
}
