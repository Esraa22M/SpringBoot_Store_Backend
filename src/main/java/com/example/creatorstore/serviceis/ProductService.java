package com.example.creatorstore.serviceis;

import com.example.creatorstore.entities.Product;
import com.example.creatorstore.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public Product createProduct(Product product){
        return productRepository.save(product);
    }
    public Product updateProduct ( Long id ,  Product product){

        //check if the product exist or not
        Product existingProduct = productRepository.findById(id).orElseThrow(()->new RuntimeException("product not found"+id));
        existingProduct.setName(product.getName());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStockQuantity(product.getStockQuantity());
        return productRepository.save(existingProduct);
    }
    public List<Product> readProducts(){
        return productRepository.findAll();
    }
    public Product getProductById(  Long id){
        return productRepository.findById(id).orElseThrow(()-> new RuntimeException("product not found"+id));
    }
    public void deleteProduct( Long id){
        productRepository.deleteById(id);
    }
}
