package com.example.creatorstore.Controllers;

import com.example.creatorstore.entities.Product;
import com.example.creatorstore.serviceis.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
//I'm going to use this particular class for rest api operations
@RestController
//we using this mapping to add path for our endpoint
@RequestMapping("/api/products")
@RequiredArgsConstructor
//read sing
public class ProductController {
    private final ProductService productService;
    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product){
        return productService.createProduct(product);
    }
    @PutMapping("/{id}")
    public Product updateProduct (@PathVariable  Long id ,@Valid @RequestBody Product product){
        return productService.updateProduct(id , product);
    }
    @GetMapping
    public List<Product>readProducts(){
        return productService.readProducts();
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable  Long id){
        return productService.getProductById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}
