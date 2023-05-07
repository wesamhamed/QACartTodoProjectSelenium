package com.qacart.todo.models.todo.getTodoById.requestBody;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
@Builder
public class GetTodoRequestBody {
}
