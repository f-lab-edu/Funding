package com.flab.funding.domain.funding.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
public class Item {

    @Id @GeneratedValue
    private long id;

//    @OneToOne(mappedBy = "item")
//    private Funding funding;

    @OneToMany(mappedBy = "item")
    private List<ItemOption> itemOption = new ArrayList<>();

    private String title;

    private String desc;
}
