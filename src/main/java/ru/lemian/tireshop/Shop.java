package ru.lemian.tireshop;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Product> productsInShop;


    public List<Product> getSaleTop(int size) {
        List<Product> products = new ArrayList<>();
        for(Product p: productsInShop) {
            if(p.isTyre()) {
                products.add(p);
            }

            if (products.size() == size) {
                break;
            }


        }
        return products;

    }


    public Product getBestTyre() {
        for(Product product: productsInShop) {
            if(product.isTyre() || (product.getWidth() > 180 && product.getWidth() <190) ) {
                return product;
            }
        }

        return null;
    }


    public List<Product> getAllProduct() {
        return productsInShop;
    }

    // new = создать объект по шаблону в оперативной памяти и вернуть ссылочку на него   |---------------------|___объект___|-------------|
    // new ArrayList = создать объект по шаблону ArrayList и вернуть ссылку на него |---------------------|___объект ArrayList()()()()()___|-------------|
    // new ArrayList<>() =  создать объект по шаблону ArrayList по конструктору по умолчанию и вернуть ссылочку на него
    // products = new - присваевает переменной products значение ссылки на объект
    // List<Product> products - ссылка на список продуктов

    // |---------------------|___объект ArrayList(ссылка на продукт1)(ссылка на продукт2)___|----|__объект Product__|--|__объект Product__|--|__объект Product__|..--|

    public Shop() {
        List<Product> products = new ArrayList<>();
        Product p = new Product();
        p.setName("Шина Cordiant");
        p.setWidth(205);
        p.setPrice("2960");
        p.setTyre(true);
        p.setHeight(55);

        products.add(p);
        products.add(new Product("Диск LA MZ43", false, 7.5f,0));
        products.add(new Product("Диск  x-Race AF-02", false, 6.0f,0));
        products.add(new Product("Шина Goodyer Eagle", true, 185,70));
        products.add(new Product("Диск  Khomen Solaris", false, 6.0f,0));
        products.add(new Product("Шина MAXXIS MT-764", true, 10.5f, 31));
        products.add(new Product("Шина Mazzini Mud", true, 285, 70));
        products.add(new Product("Шина Yokohama G075",true, 255, 50));
        products.add(new Product("Диск Alcasta M18", false, 6.5f, 0));
        products.add(new Product("Диск Megami MGM-7", false, 6.0f, 0));


        System.out.println("Создаётся магазин");

        productsInShop = products;
    }


    public static void main(String[] args) {
        Shop shop = new Shop();
//        for (Product product : shop.getSaleTop()) {
//            System.out.println(product);
//        }
        for (Product product : shop.getSaleTop( 1)) {
            System.out.println(product);
        }

//        if(shop.getAllProduct().equals(shop.getSaleTop())) {
//            System.out.println("Списки равны");
//        }else{
//            System.out.println("Списки различны");
//        }



        System.out.println("Лучшая шина: " + shop.getBestTyre());
    }
}
