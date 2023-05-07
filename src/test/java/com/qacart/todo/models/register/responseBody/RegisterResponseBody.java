package com.qacart.todo.models.register.responseBody;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterResponseBody {
    private String userID;
    @JsonProperty("access_token")
    private String access_token;
    private String firstName;
}
