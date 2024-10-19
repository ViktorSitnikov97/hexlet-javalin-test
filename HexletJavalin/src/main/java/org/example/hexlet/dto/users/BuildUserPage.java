package org.example.hexlet.dto.users;


import io.javalin.validation.ValidationError;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.hexlet.dto.BasePage;

import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor
public class BuildUserPage extends BasePage {
    private String name;
    private String email;
    private Map<String, List<ValidationError<Object>>> errors;

    public BuildUserPage(String name, Map<String, List<ValidationError<Object>>> errors) {
        this.name = name;
        this.errors = errors;
    }
}
