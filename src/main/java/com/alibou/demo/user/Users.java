package com.alibou.demo.user;

import com.alibou.demo.address.Address;
import com.alibou.demo.base.BaseClass;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
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
@Entity
@Inheritance
@DiscriminatorColumn(name = "type")
public class Users extends BaseClass {

    private String firstname;
    private String lastname;
    private String mail;

    @OneToOne
    @JoinColumn(name = "adr_id")
    private Address address;

}
