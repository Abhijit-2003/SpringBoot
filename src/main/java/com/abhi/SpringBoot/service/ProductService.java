package com.abhi.SpringBoot.service;

import com.abhi.SpringBoot.model.Product;
import com.abhi.SpringBoot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService
{
    @Autowired
    ProductRepository productRepository;

    // Create product
    public Product createProduct (Product product)
    {
        return productRepository.save(product);
    }

    public List<Product> createProducts(List<Product> products)
    {
        List<Product> list = new ArrayList<>();

        for(int i=0; i<products.size(); i++)
        {
            list.add(productRepository.save(products.get(i)));
        }

        return list;
    }

    // get All Product
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // get Product By id
    public Product getProductById(Long id)
    {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product Not found..."));
    }

    // update Product
    public Product updateProduct(Long id, Product productDetails)
    {
        Product product = getProductById(id);

        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());

        return productRepository.save(product);
    }

    // delete Product
    public void deleteProduct(Long id)
    {
        Product product = productRepository.getById(id);
        productRepository.deleteById(id);
    }
}