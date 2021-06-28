package com.thien.controller;

import com.thien.service.ProductService;
import com.thien.service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class ProductController {
    private ProductService productService = new ProductServiceImpl();
    @GetMapping("/")
    public String index(Model model){
        List list = productService.findAll();
        model.addAttribute("products", list);
        return "/index";
    }
}
