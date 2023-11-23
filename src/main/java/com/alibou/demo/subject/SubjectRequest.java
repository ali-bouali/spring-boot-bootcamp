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
    @NotNull(message = "Subject name is mandatory")
    @NotEmpty(message = "Subject name is mandatory")
    private String name;
}
