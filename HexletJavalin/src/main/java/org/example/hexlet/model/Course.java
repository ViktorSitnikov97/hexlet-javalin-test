package org.example.hexlet.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Course {
    private Long id;

    @ToString.Include
    private String title;

    private String description;

    public Course(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
