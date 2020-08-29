package ru.lemian.tireshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.lemian.tireshop.entity.Product;
import ru.lemian.tireshop.Shop;
import ru.lemian.tireshop.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShopController {
    private final Shop shop;
    private final ProductRepository productRepository;

    @GetMapping("/page")
    public List<Product> test(
            @RequestParam(required = false) int count,
            @RequestParam(required = false) int page
    ) {
        return shop.getProducts(count, page);
    }

    @GetMapping
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @GetMapping("/one")
    public Product getProduct() {
        return productRepository.findAll().get(0);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}

//количество элементов на странице
//номер страницы
