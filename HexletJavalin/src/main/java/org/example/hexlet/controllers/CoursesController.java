package org.example.hexlet.controllers;

import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import org.apache.commons.lang3.StringUtils;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.repository.UserRepository;
import org.example.hexlet.util.NamedRoutes;

import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class CoursesController {
    public static void index(Context ctx) {
        var term = ctx.queryParam("term");
        List<Course> courses;
        if (term != null) {
            courses = CourseRepository.search(term);
        } else {
            courses = CourseRepository.getEntities();
        }

        var page = new CoursesPage(courses, term);
        ctx.render("courses/index.jte", model("page", page));
    }

    public static void show(Context ctx) throws Exception {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = CourseRepository.find(id).get();
        var page = new CoursePage(course);
        ctx.render("courses/show.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildCoursePage();
        ctx.render("courses/build.jte", model("page", page));
    }

    public static void create(Context ctx) {
        try {
            var name = ctx.formParamAsClass("name", String.class)
                    .check(value -> value.length() > 2, "Название курса менее 3 символов")
                    .get();
            var description = ctx.formParamAsClass("description", String.class)
                    .check(value -> value.length() > 10, "Описание курса менее 10 символов")
                    .get();
            var course = new Course(name, description);
            CourseRepository.save(course);
            ctx.redirect("/courses");
        } catch(ValidationException e) {
            var name = ctx.formParam("name");
            var description = ctx.formParam("description");
            var page = new BuildCoursePage(name, description, e.getErrors());
            ctx.render("courses/build.jte", model("page", page));
        }
    }

    public static void edit(Context ctx) throws Exception {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = CourseRepository.find(id).get();
        var page = new CoursePage(course);
        ctx.render("courses/edit.jte", model("page", page));
    }

    public static void update(Context ctx) throws Exception {
        var id = ctx.pathParamAsClass("id", Long.class).get();

        var name = ctx.formParam("name");
        var description = ctx.formParam("description");

        try{
            var nameNew = ctx.formParamAsClass("name", String.class)
                    .check(value -> value.length() > 2, "Название курса менее 3 символов")
                    .get();
            var descriptionNew = ctx.formParamAsClass("description", String.class)
                    .check(value -> value.length() > 10, "Описание курса менее 10 символов")
                    .get();

            var course = CourseRepository.find(id).get();
            course.setName(nameNew);
            course.setDescription(descriptionNew);

            ctx.redirect(NamedRoutes.coursesPath());

        } catch(ValidationException e) {
            var page = new BuildCoursePage(name, description, e.getErrors());
            ctx.render("courses/edit.jte", model("page", page));
        }
    }

    public static void destroy(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        CourseRepository.delete(id);
        ctx.redirect(NamedRoutes.coursesPath());
    }
}
