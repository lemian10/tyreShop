package ru.lemian.tireshop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {
    private List<Product> productsInShop;


    public List<Product> getSaleTop(int diskPosition, int batteryPosition, int tyrePosition) {
        List<Product> products = new ArrayList<>();

        List<Product> productsDisk = new ArrayList<>();
        List<Product> productsBattery = new ArrayList<>();
        List<Product> productsTyre = productsInShop
                .stream()
                .filter(i -> i instanceof Tyre)
                .collect(Collectors.toList());

        for(Product p: productsInShop) {
            if(p instanceof Disk) {
                productsDisk.add(p);

            }
//            if (p instanceof Tyre){
//                productsTyre.add(p);
//            }
            if (p instanceof Battery){
                productsBattery.add(p);
            }
        }

        if (productsTyre.size() > tyrePosition) {
            products.add(productsTyre.get(tyrePosition-1));
        }else {
            System.out.println("Нема так много, есть " + productsTyre.size()+ ", а не " + tyrePosition);
        }

        if(productsDisk.size() > diskPosition) {
            products.add(productsDisk.get(diskPosition - 1));
        }else{
            System.out.println("У меня нет столько дисков, у меня всего " + productsDisk.size() + ", а ты хочешь " + diskPosition);
        }
        products.add(productsBattery.get(batteryPosition-1));

        return products;
    }


    public Product getBestTyre() {
        for(Product product: productsInShop) {
            if(product instanceof Tyre ) {
                if(((Tyre) product).getWidth() > 180 && ((Tyre) product).getWidth() <190) {
                    return product;
                }
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
        Tyre p = new Tyre();
        p.setName("Шина Cordiant");
        p.setWidth(205);
        p.setPrice("2960");
        p.setHeight(55);

        products.add(p);
        products.add(new Disk("Диск LA MZ43",  7.5f));
        products.add(new Battery("Аккумулятор Toplo"));
        products.add(new Disk("Диск  x-Race AF-02", 6.0f));
        products.add(new Tyre("Шина Goodyer Eagle",  185,70));
        products.add(new Disk("Диск  Khomen Solaris",  6.0f));
        products.add(new Tyre("Шина MAXXIS MT-764",  10.5f, 31));
        products.add(new Tyre("Шина Mazzini Mud",  285, 70));
        products.add(new Tyre("Шина Yokohama G075", 255, 50));
        products.add(new Disk("Диск Alcasta M18",  6.5f));
        products.add(new Disk("Диск Megami MGM-7",  6.0f));
        products.add(new Battery("Аккумулятор Барс"));


        System.out.println("Создаётся магазин");

        productsInShop = products;
    }


    public static void main(String[] args) {
        Shop shop = new Shop();
//        for (Product product : shop.getSaleTop()) {
//            System.out.println(product);
//        }
        for (Product product : shop.getSaleTop( 10, 1, 2)) {
            System.out.println(product);
        }

        System.out.println("Лучшая шина: " + shop.getBestTyre());
    }
}
