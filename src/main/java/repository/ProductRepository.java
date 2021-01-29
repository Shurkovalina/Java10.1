package repository;

import domain.Product;

public class ProductRepository {
    private Product[] items = new Product[0];

    //    метод, позволяющий сохранять продукты
    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    //    метод, используемый для получения сохранённых продуктов
    public Product[] findAll() {
        return items;
    }

    //    метод, удаляющий продукты по id
    public void removeById(int id) {
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
