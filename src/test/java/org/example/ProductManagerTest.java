package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    ShopRepository repo = new ShopRepository();
    ProductManager manager = new ProductManager(repo);
    ProductManager manager2 = new ProductManager();
    Smartphone product1 = new Smartphone(1, "Смартфон", 10000, "Redmi", "Xiaomi");
    Book product2 = new Book(2, "Сказка", 100, "О царе", "Пушкин");
    Book product3 = new Book(3, "Роман", 300, "Герой", "Лермонтов");

    @BeforeEach
    public void setUp() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
    }

    @Test
    public void testSearchBook() {

        Product[] expected = {product2};
        Product[] actual = manager.searchBy("Сказка");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchSmartphone() {

        Product[] expected = {product1};
        Product[] actual = manager.searchBy("Смартфон");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchNoResult() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("Телефон");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchResult() {

        Product[] expected = {product1, product2, product3};
        Product[] actual = manager.searchBy("");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddProduct() {
        Smartphone product4 = new Smartphone(4, "Смартфон", 15000, "A51", "Samsung");
        manager.add(product4);
        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}

