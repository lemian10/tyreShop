package ru.lemian.tireshop.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private String price;

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Продукт: " + name;
    }
}
