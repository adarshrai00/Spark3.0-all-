package org.example.ecommerce.service;

import org.example.ecommerce.model.Product;
import org.example.ecommerce.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public List<Product> getAllProducts() {
        return productRepository.findAll();

    }

    public Product getProductById(int id) {

        return    productRepository.findById(id).orElse(null);
    }

    public Product addProduct(Product product) {
       return  productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(Math.toIntExact(id));
    }
}
