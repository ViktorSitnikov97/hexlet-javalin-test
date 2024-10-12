package org.example.hexlet.dto;

import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class MainPage {
    private Boolean visited;
    private String currentUser;
    private Map<String, List<ValidationError<Object>>> errors;

    public Boolean isVisited() {
        return visited;
    }
}
