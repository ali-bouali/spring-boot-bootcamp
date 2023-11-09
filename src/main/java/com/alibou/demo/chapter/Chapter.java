package com.alibou.demo.chapter;

import com.alibou.demo.subject.Subject;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Chapter {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "sub_id")
    private Subject subject;
}
