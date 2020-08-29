package ru.lemian.tireshop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lemian.tireshop.entity.Product;
import ru.lemian.tireshop.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class Shop {
    private final ProductRepository repository;

    /**
     * Ссылка на список товаров в магазине в данном классе
     */
    private List<Product> productsInShop;

    public Product addProduct(Product product) {
        return repository.save(product);
    }

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

    /**
     * Метод возвращающий товары с разбитием на страницы
     * @param count количество элементов на странице
     * @param page номер страницы ( нумерация с 0 )
     * @return элементы на данной странице
     */
    public List<Product> getProducts(int count, int page){
        int currentPage = 0;
        int itemInPage = 0;
        List<Product> productsInPage = new ArrayList<>();

        for(Product product: repository.findAll()) {
            itemInPage++;
            System.out.println("Элемент №" + itemInPage);

            if(itemInPage == count) {
                System.out.println("Новая страница №" + currentPage);
                currentPage++;
                itemInPage = 0;
            }

            if(currentPage == page) {
                System.out.println("элемент подходит");
                productsInPage.add(product);
            }
        }

        return productsInPage;
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

    /**
     * Метод возвращает список товаров содержащих в имени переданную строку
     * @param partName строка по которой нужно осуществлять поиск
     * @return возвращяем отфильтрованный список товаров
     */
    public List<Product> search(String partName){
       List<Product> productsSearched = new ArrayList<>();
       for (Product product: productsInShop){
           if (product.getName().toLowerCase().contains(partName.toLowerCase())){
               productsSearched.add(product);
           }

       }
        return productsSearched;

    }
}
