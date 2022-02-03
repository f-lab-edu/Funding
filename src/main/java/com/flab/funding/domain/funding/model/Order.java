package com.flab.funding.domain.funding.model;

import com.flab.funding.domain.user.model.Orderer;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="orderer_id")
    private Orderer orderer;

    @ManyToOne
    @JoinColumn(name="funding_id")
    private Funding funding;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> details = new ArrayList<>();

    private LocalDateTime orderDt;

    private int totalPrice;

    private OrderStatus orderStatus;
}
