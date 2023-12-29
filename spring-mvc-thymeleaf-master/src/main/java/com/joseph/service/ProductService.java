package com.joseph.service;

import java.util.List;

import com.joseph.entity.Customer;
import com.joseph.entity.Product;
// import com.joseph..exception.ResourceNotFoundException;

public interface ProductService {

    public List<Product> getProducts();

    public void saveProduct(Product theCustomer);

    public Product getProduct(int theId);

    public void deleteProduct(int theId);

}