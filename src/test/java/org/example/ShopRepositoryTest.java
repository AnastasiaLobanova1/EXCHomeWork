package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository shop = new ShopRepository();

    Product product1 = new Product(1, "Телефон", 10000);
    Product product2 = new Product(2, "Сказка", 100);
    Product product3 = new Product(3, "Роман", 300);


    @BeforeEach
    public void setUp() {
        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
    }

    @Test
    public void testAddProduct() {
        Product product4 = new Product(4, "Honor", 15000);
        shop.add(product4);
        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = shop.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindProduct() {

        Product expected = product1;
        Product actual = shop.findById(1);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testFindProductNull() {

        Product expected = null;
        Product actual = shop.findById(4);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testShouldSetTitleProduct () {

        product1.setTitle("книга");

        Assertions.assertEquals("книга", product1.getTitle());
    }
    @Test
    public void testShouldSetPriceProduct () {

        product1.setPrice(100);

        Assertions.assertEquals(100, product1.getPrice());
    }

    @Test
    public void testShouldSetTitleBook () {
        Book book = new Book(5, "книга", 150, "Без названия", "Без автора");
        book.setNameBook("12 стульев");

        Assertions.assertEquals("12 стульев", book.getNameBook());
    }
    @Test
    public void testShouldSetAuthorBook () {
        Book book = new Book(5, "книга", 150, "Без названия", "Без автора");
        book.setAuthor("Петров");

        Assertions.assertEquals("Петров", book.getAuthor());
    }
    @Test
    public void testShouldSetNamePhoneSmartphone() {
        Smartphone smartphone = new Smartphone (5, "телефон", 15000, "Без названия", "Без названия");
        smartphone.setNamePhone("Samsung");

        Assertions.assertEquals("Samsung", smartphone.getNamePhone());
    }
    @Test
    public void testShouldSetManufacturerSmartphone() {
        Smartphone smartphone = new Smartphone (5, "телефон", 15000, "Без названия", "Без названия");
        smartphone.setManufacturer("Samsung");

        Assertions.assertEquals("Samsung", smartphone.getManufacturer());
    }
    @Test
    public void testRemoveById() {
        shop.removeById(2);
        Product[] expected = {product1, product3};
        Product[] actual = shop.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testNotFoundException() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            shop.removeById(20);
        });
    }
}
