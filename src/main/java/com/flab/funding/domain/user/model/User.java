package com.flab.funding.domain.user.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
public class User {

    @Id @GeneratedValue
    private long id;

    // 회원 아이디
    @NotNull
    private String userId;

    // 회원 비밀번호
    @NotNull
    private String password;

    // 회원 이름
    @NotNull
    private String name;

    // 회원 이메일
    private String email;

    // 회원 연락처
    private String phone;

    // 회원 주소
    @OneToMany(mappedBy = "user", fetch= FetchType.LAZY)
    private List<Address> address = new ArrayList<> ();

    // 회원 역할 (판매자, 구매자)
    @NotNull
    private UserRole userRole;
}
