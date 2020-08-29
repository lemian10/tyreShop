package ru.lemian.tireshop;

import lombok.Getter;
import lombok.Setter;
import ru.lemian.tireshop.entity.Product;

@Getter
@Setter
public class Tyre extends Product {
    private float width;
    private int height;

    Tyre (String name, float width, int height) {
        this.width = width;
        this.height = height;
        setName(name);
    }
    Tyre (){}
}

