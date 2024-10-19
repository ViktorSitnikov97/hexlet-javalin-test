package org.example.hexlet.controllers;

import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.courses.EditCoursePage;
import org.example.hexlet.model.Course;
import org.example.hexlet.repository.CourseRepository;
import org.example.hexlet.util.NamedRoutes;

import java.sql.SQLException;
import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class CoursesController {
    public static void index(Context ctx) throws SQLException {
        var term = ctx.queryParam("term");
        List<Course> courses;
        if (term != null) {
            courses = CourseRepository.search(term);
        } else {
            courses = CourseRepository.getEntities();
        }

        var page = new CoursesPage(courses, term);
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        page.setFlag(true);
        ctx.render("courses/index.jte", model("page", page));
    }

    public static void show(Context ctx) throws Exception {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = CourseRepository.findById(id).get();
        var page = new CoursePage(course);
        ctx.render("courses/show.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildCoursePage();
        ctx.render("courses/build.jte", model("page", page));
    }

    public static void create(Context ctx) throws SQLException {

        try {
            var title = ctx.formParamAsClass("title", String.class)
                    .check(value -> value.length() > 2, "Название курса менее 3 символов")
                    .check(value -> !CourseRepository.existsByTitle(value, 0L), "Курс с таким названием уже существует")
                    .get();
            var description = ctx.formParamAsClass("description", String.class)
                    .check(value -> value.length() > 10, "Описание курса менее 10 символов")
                    .get();
            var course = new Course(title, description);
            CourseRepository.save(course);
            ctx.sessionAttribute("flash", "Course has been created!");

            ctx.redirect("/courses");
        } catch (ValidationException e) {
            var title = ctx.formParam("course");
            var description = ctx.formParam("description");
            var page = new BuildCoursePage(title, description, e.getErrors());
            ctx.sessionAttribute("flash", "Course has not been created!");
            page.setFlash(ctx.consumeSessionAttribute("flash"));
            page.setFlag(false);
            ctx.render("courses/build.jte", model("page", page));
        }
    }

    public static void edit(Context ctx) throws Exception {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = CourseRepository.findById(id).get();
        var title = course.getTitle();
        var description = course.getDescription();
        var page = new EditCoursePage(id, title, description, null);
        ctx.render("courses/edit.jte", model("page", page));
    }

    public static void update(Context ctx) throws Exception {

        var id = ctx.pathParamAsClass("id", Long.class).get();
        var title = ctx.formParam("title");
        var description = ctx.formParam("description");
        var courseCurrent = CourseRepository.findById(id).get();

        try{
            var titleNew = ctx.formParamAsClass("title", String.class)
                    .check(value -> value.length() > 2, "Название курса менее 3 символов")
                    .check(value -> !CourseRepository.existsByTitle(value, courseCurrent.getId()), "Курс с таким названием уже существует")
                    .get();
            var descriptionNew = ctx.formParamAsClass("description", String.class)
                    .check(value -> value.length() > 10, "Описание курса менее 10 символов")
                    .get();

            var course = CourseRepository.findById(id).get();
            course.setTitle(titleNew);
            course.setDescription(descriptionNew);
            CourseRepository.update(course);
            ctx.sessionAttribute("flash", "Course has been updated!");
            ctx.redirect(NamedRoutes.coursesPath());

        } catch (ValidationException e) {
            var page = new EditCoursePage(id, title, description, e.getErrors());
            ctx.sessionAttribute("flash", "Course has not been updated!");
            page.setFlash(ctx.consumeSessionAttribute("flash"));
            page.setFlag(false);
            ctx.render("courses/edit.jte", model("page", page));
        }
    }

    public static void destroy(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        CourseRepository.delete(id);
        ctx.sessionAttribute("flash", "Course has been deleted!");
        ctx.redirect(NamedRoutes.coursesPath());
    }
}
