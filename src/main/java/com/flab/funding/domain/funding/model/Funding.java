package com.flab.funding.domain.funding.model;

import com.flab.funding.domain.user.model.Seller;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
public class Funding {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private LocalDateTime cretDt;

    private LocalDateTime startDt;

    private LocalDateTime endDt;

    private int goalPrice;

    private int orderedPrice;

    private OrderStatus orderStatus;
}
