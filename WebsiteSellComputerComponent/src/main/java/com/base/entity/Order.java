package com.base.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

//    @ManyToOne
//    @JoinColumn(name = "shipping_id", nullable = false)
//    private Shipping shipping;

    @Column(name = "order_date", updatable = false, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate orderDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @Column(nullable = false, length = 255)
    private String note;

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @Column(nullable = false)
    private Double tax;

    @Column(name = "grand_total", nullable = false)
    private Double grandTotal;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

    
    public enum OrderStatus {
        PENDING,
        PROCESSING,
        SHIPPED,
        DELIVERED,
        CANCELED
    }

}
