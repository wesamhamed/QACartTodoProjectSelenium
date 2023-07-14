package com.qacart.todo.models.todo.addTodo.requestBody;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddTodoRequestBody {
    private String item;
    @JsonProperty("isCompleted")
    private Boolean isCompleted;
}
