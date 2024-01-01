package com.joseph.web;

import com.joseph.entity.OrdreEntity;
import com.joseph.entity.Product;
import com.joseph.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public String listProducts(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "list-prod";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);

        return "add-prod";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/product/list";
    }

    @GetMapping("/updatepage")
    public String showFormForUpdate(@RequestParam("id") Long id, Model model) {
        Product product = productService.getProduct(id);
        model.addAttribute("product", product);
        return "upd-prod";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/product/list";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("id") Long id) {
        productService.deleteProduct(id);
        return "redirect:/product/list";
    }

    @GetMapping("/addOrder")
    public String showAddOrderForm(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        model.addAttribute("order", new OrdreEntity());
        return "addorder";
    }
}
