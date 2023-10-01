package com.alibou.demo.address;

import com.alibou.demo.base.BaseClass;
import com.alibou.demo.user.Users;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {

    private String adr;
    private String adr1;
    private String adr2;
}
