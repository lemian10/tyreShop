package ru.lemian.tireshop;

import java.util.ArrayList;
import java.util.List;

public class DB {
    public static List<Product> getAllProducts() {
        List<Product> allProducts = new ArrayList<>();

        allProducts.add(new Tyre("Шина Cordiant", 205, 55));
        allProducts.add(new Disk("Диск LA MZ43",  7.5f));
        allProducts.add(new Battery("Аккумулятор Toplo"));
        allProducts.add(new Disk("Диск  x-Race AF-02", 6.0f));
        allProducts.add(new Tyre("Шина Goodyer Eagle",  185,70));
        allProducts.add(new Disk("Диск  Khomen Solaris",  6.0f));
        allProducts.add(new Tyre("Шина MAXXIS MT-764",  10.5f, 31));
        allProducts.add(new Tyre("Шина Mazzini Mud",  285, 70));
        allProducts.add(new Tyre("Шина Yokohama G075", 255, 50));
        allProducts.add(new Disk("Диск Alcasta M18",  6.5f));
        allProducts.add(new Disk("Диск Megami MGM-7",  6.0f));
        allProducts.add(new Battery("Аккумулятор Барс"));

        return allProducts;
    }
}
