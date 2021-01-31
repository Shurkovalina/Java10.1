package manager;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();

    @Test
    public void search1() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(new Book(1, "book", 10, "a"));
        manager.add(new Smartphone(2, "Smart", 100, "Samsung"));

        assertArrayEquals();

    }
}