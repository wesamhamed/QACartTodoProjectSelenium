package com.qacart.todo.models.register.requestBody;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequestBody {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
