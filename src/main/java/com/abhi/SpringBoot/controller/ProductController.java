package com.abhi.SpringBoot.controller;

import com.abhi.SpringBoot.model.Product;
import com.abhi.SpringBoot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController
{
    @Autowired
    ProductService productService;


    // Create New Product
    @PostMapping("/save")
    public Product createProduct(@RequestBody Product product)
    {
        return productService.createProduct(product);
    }

    // add Multiple product
    @PostMapping("/saves")
    public List<Product> createProducts(@RequestBody List<Product> products)
    {
        return productService.createProducts(products);
    }

    @GetMapping("/Products")
    public List<Product> getAllProduct()
    {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id)
    {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails)
    {
        return productService.updateProduct(id, productDetails);
    }

    @GetMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id)
    {
        productService.deleteProduct(id);
    }
}
