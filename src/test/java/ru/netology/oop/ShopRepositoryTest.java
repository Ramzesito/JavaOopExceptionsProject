package ru.netology.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product product1 = new Product(11, "Product 11", 1111);
    Product product2 = new Product(2, "Product 2", 222);
    Product product3 = new Product(333, "Product 333", 33);
    Product product4 = new Product(4444, "Product 4444", 4);

    @Test
    public void shouldDeleteProductByValidId() {
        ShopRepository repository = new ShopRepository();
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);
        repository.remove(333);
        Product[] expected = {product1, product2, product4};

        Assertions.assertArrayEquals(expected, repository.findAll());
    }

    @Test
    public void shouldThrowNotFoundExceptionIfInvalidId() {
        ShopRepository repository = new ShopRepository();
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.remove(3333);
        });
    }

    @Test
    public void shouldThrowAlreadyExistsExceptionIfIdExists() {
        ShopRepository repository = new ShopRepository();
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repository.add(product1);
        });
    }

}
