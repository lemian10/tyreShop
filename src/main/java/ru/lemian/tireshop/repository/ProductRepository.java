package ru.lemian.tireshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lemian.tireshop.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product getProductByName(String name);
}
