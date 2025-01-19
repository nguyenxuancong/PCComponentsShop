package com.base.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Integer orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
//
//    @ManyToOne
//    @JoinColumn(name = "product_id", nullable = false)
//    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "unit_price", nullable = false)
    private Double unitPrice;

    @Column(nullable = false)
    private Double subtotal;

    @Column(name = "order_item_date", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate orderItemDate;
}
