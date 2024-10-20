package org.example.hexlet.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    public static String usersPath() {
        return "/users";
    }
    public static String buildUserPath() {
        return "/users/build";
    }
    public static String userPath(String id) {
        return "/users/" + id;
    }
    public static String userPath(Long id) {
        return userPath(String.valueOf(id));
    }
    public static String userEditPath(String id) {
        return "/users/" + id + "/edit";
    }
    public static String userEditPath(Long id) {
        return userEditPath(String.valueOf(id));
    }
    public static String userDeletePath(String id) {
        return "/users/" + id + "/delete";
    }
    public static String userDeletePath(Long id) {
        return userDeletePath(String.valueOf(id));
    }



    public static String coursesPath() {
        return "/courses";
    }
    public static String buildCoursePath() {
        return "/courses/build";
    }
    public static String coursePath(String id) {
        return "/courses/" + id;
    }
    public static String coursePath(Long id) {
        return coursePath(String.valueOf(id));
    }
    public static String courseEditPath(String id) {
        return "/courses/" + id + "/edit";
    }
    public static String courseEditPath(Long id) {
        return courseEditPath(String.valueOf(id));
    }

    public static String courseDeletePath(String id) {
        return "/courses/" + id + "/delete";
    }
    public static String courseDeletePath(Long id) {
        return courseDeletePath(String.valueOf(id));
    }

    public static String buildSessionPath() {
        return "/sessions/build";
    }
    public static String loginPath() {
        return "/sessions";
    }
    public static String logoutPath() {
        return "sessions/delete";
    }


}
