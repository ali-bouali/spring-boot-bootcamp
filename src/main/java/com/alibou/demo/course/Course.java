package com.alibou.demo.course;

import com.alibou.demo.address.Address;
import com.alibou.demo.base.BaseClass;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Course extends BaseClass {

    private String name;

    @Embedded
    private Address address;
}
