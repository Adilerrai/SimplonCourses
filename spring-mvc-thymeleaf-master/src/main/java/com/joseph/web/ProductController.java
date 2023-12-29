package com.joseph.web;

import com.joseph.entity.Customer;
import com.joseph.entity.Product;
import com.joseph.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public String listProducts(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "product-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product-form";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/products/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("productId") int productId, Model model) {
        Product product = productService.getProduct(productId);
        model.addAttribute("product", product);
        return "product-form";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("productId") int productId) {
        productService.deleteProduct(productId);
        return "redirect:/products/list";
    }
}
