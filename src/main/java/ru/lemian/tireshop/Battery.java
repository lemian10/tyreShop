package ru.lemian.tireshop;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Battery extends Product {
    private int capasity;
    private String bodyIndex;

    Battery (String name){
        setName(name);
    }
}
