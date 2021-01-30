package manager;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import repository.ProductRepository;

import java.util.Arrays;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public Product[] items = new Product[0];

    public ProductManager() {
    }

    public ProductManager(Product[] items) {
        this.items = items;
    }

    //    метод, добавляющий продукты в репозиторий
    public void add(Product item) {
        repository.save(item);
    }


    //    метод, который возвращает массив найденных товаров
    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll())
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(items, 0, tmp, 0, items.length);
                int lastIndex = tmp.length - 1;
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        return result;
    }

    //    метод, проверяющий, соответствует ли продукт поисковому запросу
    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        } else {
            if (product instanceof Smartphone) {
                Smartphone smartphone = (Smartphone) product;
                if (smartphone.getName().equalsIgnoreCase(search)) {
                    return true;
                }
                if (smartphone.getManufacturer().equalsIgnoreCase(search)) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }

}