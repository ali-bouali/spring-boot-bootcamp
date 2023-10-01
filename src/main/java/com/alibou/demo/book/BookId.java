package com.alibou.demo.book;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class BookId implements Serializable {

    private String userEmail;
    private LocalDate date;

    // userId:1 - date:01.10.2023
}
