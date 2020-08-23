package ru.lemian.tireshop;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {
    private String name;
    private String price;
    private boolean tyre;
    private float width;
    private int height;

    Product (String name, boolean tyre, float width, int height) {
        this.name = name;
        this.tyre = tyre;
        this.width = width;
        this.height = height;
    }

    void setWidth(float width) {
        int koeficientUmnojWisoti = 2;
        this.width = width;
        this.height = (int) (width * koeficientUmnojWisoti);
    }

    @Override
    public String toString() {
        return "Продукт: " + name;
    }
}
