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

    public void add(Product item) {
        repository.save(item);
    }

    public Product[] searchBy(String requiredProduct) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (product.matches(requiredProduct)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

}
