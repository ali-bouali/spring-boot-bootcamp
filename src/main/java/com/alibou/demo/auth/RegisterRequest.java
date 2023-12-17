package com.alibou.demo.auth;

import jakarta.validation.constraints.Email;
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
public class RegisterRequest {

    @NotNull(message = "Firstname must not be null")
    private String firstname;
    @NotNull(message = "Lastname must not be null")
    private String lastname;
    @NotNull(message = "Email must not be null")
    @NotEmpty(message = "Email must not be null")
    @Email(message = "Email is not well formatter")
    private String email;
    @NotNull(message = "Password must not be null")
    @NotEmpty(message = "Password must not be null")
    private String password;
}
