package com.alibou.demo.student;

import com.alibou.demo.address.Address;
import com.alibou.demo.subject.Subject;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private int age;


    @OneToOne(mappedBy = "student")
    private Address address;

    @ManyToMany
    @JoinTable(
            name = "std_sub",
            joinColumns = {@JoinColumn(name = "std_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "sub_id", referencedColumnName = "id")}
    )
    // @JsonManagedReference
    private List<Subject> subjects;
}
