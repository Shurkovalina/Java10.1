package domain;

import repository.ProductRepository;

public class Book extends Product {
    private String author;

    public Book(ProductRepository repository) {
        super();
    }

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        return author.equalsIgnoreCase(search);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
