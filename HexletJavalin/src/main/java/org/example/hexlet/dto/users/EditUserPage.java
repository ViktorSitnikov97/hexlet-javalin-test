package org.example.hexlet.dto.users;

import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EditUserPage {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Map<String, List<ValidationError<Object>>> errors;
}
