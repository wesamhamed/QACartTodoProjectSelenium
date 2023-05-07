package com.qacart.todo.models.todo.deleteTodoById.responseBody;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteTodoByIdResponseBody {
    @JsonProperty("_id")
    private String id;
    private String userID;
    private String createdAt;
    @JsonProperty("__v")
    private String v;
    private String item;
    @JsonProperty("isCompleted")
    private Boolean isCompleted;
}
