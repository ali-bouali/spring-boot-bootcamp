package com.alibou.demo.address;

import com.alibou.demo.base.BaseClass;
import com.alibou.demo.user.Users;
import jakarta.persistence.Entity;
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
public class Address extends BaseClass {

    private String adr;
    private String adr1;
    private String adr2;

    @OneToOne
    @JoinColumn(name = "usr_id")
    private Users user;
}
