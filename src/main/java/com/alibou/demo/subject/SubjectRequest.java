package com.alibou.demo.subject;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectRequest {

    private Integer id;
    @NotNull(message = "100")
    @NotEmpty(message = "100")
    private String name;
    @NotNull(message = "101")
    @NotEmpty(message = "101")
    private String description;
}
