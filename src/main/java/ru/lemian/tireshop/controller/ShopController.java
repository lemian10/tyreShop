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
    private final ProductRepository db;

    @GetMapping("/page")
    public List<Product> test(
            @RequestParam(required = false) int count,
            @RequestParam(required = false) int page
    ) {
        return shop.getProducts(count, page);
    }

    @GetMapping
    public List<Product> getAll() {
        return db.findAll();
    }

    @GetMapping("/one")
    public Product getProduct() {
        return db.findAll().get(0);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product p) {
        System.out.println(p);
        String productName = p.getName();
        Product tovar = db.getProductByName(p.getName());
       if(tovar == null ) {
           return db.save(p);
       }else{
           System.out.println("Товар есть " + tovar.getId());
           return null;
       }
    }
}

//количество элементов на странице
//номер страницы
