package manager;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    public void search1() {
        ProductManager manager = new ProductManager(new ProductRepository());
        Product product1 = new Book(1, "book1", 10, "author1");
        Product product2 = new Book(2, "book2", 20, "author2");
        Product product3 = new Book(3, "book3", 30, "author3");
        Product product4 = new Smartphone(4, "Smart", 100, "Samsung");

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);

        Product[] expected = new Product[]{product3};
        Product[] actual = manager.searchBy("book3");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void search2() {
        ProductManager manager = new ProductManager(new ProductRepository());
        Product product1 = new Book(1, "book1", 10, "author1");
        Product product2 = new Smartphone(4, "Smart", 100, "Samsung");

        manager.add(product1);
        manager.add(product2);

        Product[] expected = new Product[]{product2};
        Product[] actual = manager.searchBy("Samsung");

        assertArrayEquals(expected, actual);
    }

    @Test
    void bookMatches1() {
        Book book = new Book(1,"book", 10, "author");
        assertTrue(book.matches("book"));
    }

    @Test
    void bookMatches2() {
        Book book = new Book(1,"book", 10, "author");
        assertTrue(book.matches("author"));
    }

    @Test
    void smartphoneMatches() {
        Smartphone smartphone = new Smartphone(1,"smart", 10, "samsung");
        assertTrue(smartphone.matches("samsung"));
    }

    @Test
    void productMatches() {
        Product product1 = new Product(1,"bookFirst", 10);
        Product product2 = new Product(1,"bookSecond", 10);
        assertTrue(product2.matches("bookSecond"));

    }

    @Test
    public void search3() {
        ProductManager manager = new ProductManager(new ProductRepository());
        Product product1 = new Book(1, "book1", 10, "author1");
        Product product2 = new Book(2, "book2", 20, "author2");
        Product product3 = new Book(3, "book3", 30, "author3");
        Product product4 = new Smartphone(4, "Smart", 100, "Samsung");

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);

        Product[] expected = new Product[]{product4};
        Product[] actual = manager.searchBy("Samsung");

        assertArrayEquals(expected, actual);
    }

}
