package org.example.hexlet.dto.courses;

import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.hexlet.dto.BasePage;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EditCoursePage extends BasePage {
    private Long id;
    private String name;
    private String description;
    private Map<String, List<ValidationError<Object>>> errors;
}
