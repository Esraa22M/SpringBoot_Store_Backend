package com.example.creatorstore.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder //BUILDER DESIGN PATTERN
public  class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id ;
    @Column(nullable = false)
    @NotBlank(message = "Product name is required")
    private String name;
    private String description;
    private String category;
    @DecimalMin(value = "0.0", inclusive = false , message = "Price must be greater than zero")
    @Column(nullable = false)
    @NotNull(message = "Price is required!")
    private BigDecimal price;
    @Min(value = 0 , message = "stock cannot be less than zero")
    @NotNull(message = "stock quantity is required")
    @Column(name="stock_quantity",nullable = false)
    private Integer stockQuantity;
    private LocalDateTime createdAt;
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;
    @PrePersist
    public void prePersist(){
        this.createdAt=LocalDateTime.now();
    }
    //TO DO RELEATION
}


