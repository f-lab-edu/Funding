package com.flab.funding.domain.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
public class Address {

    @Id
    @GeneratedValue
    private long id;

//    @ManyToOne
//    @JoinColumn(name = "id")
//    private User user;

    private String si;

    private String gu;

    private String dong;
}
