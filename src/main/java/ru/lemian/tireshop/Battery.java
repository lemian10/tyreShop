package ru.lemian.tireshop;

import lombok.Getter;
import lombok.Setter;
import ru.lemian.tireshop.entity.Product;

@Getter
@Setter
public class Battery extends Product {
    private int capasity;
    private String bodyIndex;

    Battery (String name){
        setName(name);
    }
}
