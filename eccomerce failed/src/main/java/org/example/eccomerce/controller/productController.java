package org.example.eccomerce.controller;


import org.example.eccomerce.model.Product;
import org.example.eccomerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")

public class productController {
     @Autowired
    ProductService productService;

     @GetMapping
    List<Product> getAllProducts()
    {
        return productService.getAllProducts;
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable long id) {
    return productService.getProductById(id);
    }
    @PostMapping
   public Product addProduct(@RequestBody Product product) {
          return productService.addProduct(product);

   }
   @DeleteMapping("/{id}")
   public void deleteProduct(@PathVariable long id) {
         productService.deleteProduct(id);
   }
}
