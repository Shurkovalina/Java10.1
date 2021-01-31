package manager;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public Product[] items = new Product[0];

    //    метод, добавляющий продукты в репозиторий
    public void add(Product item) {
        repository.save(item);
    }

    //    метод, который возвращает массив найденных товаров
    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(items, 0, tmp, 0, items.length);
                int lastIndex = tmp.length - 1;
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

}
