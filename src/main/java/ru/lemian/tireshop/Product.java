package ru.lemian.tireshop;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Product {
    private int id;
    private String name;
    private String price;
    private List<String> place;

    Product (String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Продукт: " + name;
    }
}
