package manager;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private Product[] products;
    private ProductManager manager = new ProductManager(new ProductRepository());
    private ProductRepository productRepository = new ProductRepository();

    @Test
    public void setAnEmpty() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("book3");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void setOfOneElement() {
        products = new Product[1];
        products[0] = new Book(1, "book1", 10, "author1");

        manager.add(products[0]);

        Product[] expected = new Product[]{products[0]};
        Product[] actual = manager.searchBy("book1");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void search1() {
        products = new Product[4];
        products[0] = new Book(1, "book1", 10, "author1");
        products[1] = new Book(2, "book2", 20, "author2");
        products[2] = new Book(3, "book3", 30, "author3");
        products[3] = new Smartphone(4, "Smart", 100, "Samsung");

        for (int i = 0; i < 4; i++)
            manager.add(products[i]);

        Product[] expected = new Product[]{products[2]};
        Product[] actual = manager.searchBy("book3");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void search3() {
        products = new Product[2];
        products[0] = new Book(1, "book1", 10, "author1");
        products[1] = new Smartphone(4, "Smart", 100, "Samsung");

        for (int i = 0; i < 2; i++)
            manager.add(products[i]);

        Product[] expected = new Product[]{products[1]};
        Product[] actual = manager.searchBy("Samsung");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void search4() {
        products = new Product[4];
        products[0] = new Book(1, "book1", 10, "author1");
        products[1] = new Book(2, "book2", 20, "author");
        products[2] = new Book(3, "book3", 30, "author");
        products[3] = new Smartphone(4, "Smart", 100, "Samsung");

        for (int i = 0; i < 4; i++)
            manager.add(products[i]);

        Product[] expected = new Product[]{products[1], products[2]};
        Product[] actual = manager.searchBy("author");

        assertArrayEquals(expected, actual);
    }

    @Test
    void bookMatches1() {
        Book book = new Book(1, "book", 10, "author");
        assertEquals(true, book.matches("book"));
    }

    @Test
    void bookMatches2() {
        Book book = new Book(1, "book", 10, "author");
        assertEquals(true, book.matches("author"));
    }

    @Test
    void smartphoneMatches() {
        Smartphone smartphone = new Smartphone(1, "smart", 10, "samsung");
        assertEquals(true, smartphone.matches("samsung"));
    }

    @Test
    void productMatches() {
        Product product1 = new Product(1, "bookFirst", 10);
        Product product2 = new Product(1, "bookSecond", 10);
        assertEquals(true, product2.matches("bookSecond"));

    }

}
