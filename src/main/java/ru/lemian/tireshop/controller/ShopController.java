package ru.lemian.tireshop.controller;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.lemian.tireshop.DB;
import ru.lemian.tireshop.Product;
import ru.lemian.tireshop.Shop;

import java.util.List;

@RestController
public class ShopController {
    private Shop shop = new Shop();

    @GetMapping
    public List<Product> test(
            @RequestParam(required = false) int count,
            @RequestParam(required = false) int page
    ) {
        return shop.getProducts(count, page);
    }
}

//количество элементов на странице
//номер страницы
