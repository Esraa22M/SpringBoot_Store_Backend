package com.example.creatorstore.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(nullable = false , name = "customer_name")
    private String customerName;
    @OneToMany(mappedBy = "order")
    private List<OrderItem>orderItems;
    @Column(nullable = false , name = "customer_email")

    private String customerEmail;
    @Column(nullable = false)
    private String status;
    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @PrePersist
    public void prePersist(){
        this.createdAt=LocalDateTime.now();
    }
}
