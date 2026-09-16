package com.example.creatorstore.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_item")
@Builder
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(nullable = false)
    private Integer quantity;
    @Column( name ="price_at_purchase", nullable = false  )
    private BigDecimal priceAtPurchase;
    //TO DO RELATIONS
    @JoinColumn(name = "order_id" , nullable = false)
    @ManyToOne
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
