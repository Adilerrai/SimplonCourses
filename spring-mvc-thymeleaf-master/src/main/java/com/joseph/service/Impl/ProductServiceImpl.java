package com.joseph.service.Impl;

import java.util.List;

import com.joseph.entity.Product;
import com.joseph.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joseph.repository.ProductRepository; // Assuming you have a ProductRepository
// import com.joseph.exception.ResourceNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository; // Use ProductRepository here

    @Override
    @Transactional
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public void saveProduct(Product theProduct) {
        productRepository.save(theProduct);
    }

    @Override
    @Transactional
    public Product getProduct(int id) throws NullPointerException {
        return productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("Product with ID = " + id + " is not found"));
    }

    @Override
    @Transactional
    public void deleteProduct(int theId) {
        productRepository.deleteById(theId);
    }
}
