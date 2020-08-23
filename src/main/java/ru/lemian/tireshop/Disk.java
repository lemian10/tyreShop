package ru.lemian.tireshop;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Disk extends Product {
    private float width;

    Disk (String name, float width){
        this.width = width;
        setName(name);
    }

}
