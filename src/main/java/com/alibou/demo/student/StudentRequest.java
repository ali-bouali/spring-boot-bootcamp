package com.alibou.demo.student;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
public class StudentRequest {

    private Integer id;
    @NotNull(message = "Firstname must not be null")
    private String firstname;
    @NotNull(message = "Lastname must not be null")
    private String lastname;
    @NotNull
    @Positive
    @Min(value = 18, message = "Student must be at least 18 YO")
    private int age;
}
