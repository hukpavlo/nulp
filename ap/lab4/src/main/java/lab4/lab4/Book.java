package lab4.lab4;

import org.springframework.http.HttpStatus;

import java.util.UUID;

public class Book {
    private Integer price;
    private final String name;
    private final String itemId;
    private final String authorName;

    Book(String authorName, String name, int price) {
        this.name = name;
        this.price = price;
        this.authorName = authorName;
        this.itemId = UUID.randomUUID().toString();
    }

    public Integer getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setPrice(Integer price) {
        if (price <= 0) {
            throw new HttpError("Price must be great than 0", HttpStatus.BAD_REQUEST);
        }

        this.price = price;
    };

    public void validate() {
        if (!(this.price instanceof Integer && price > 0)) {
            throw new HttpError("Price must be integer and great than 0", HttpStatus.BAD_REQUEST);
        }

        if (!(this.name instanceof String && this.name.length() > 0)) {
            throw new HttpError("Invalid book name", HttpStatus.BAD_REQUEST);
        }

        if (!(this.authorName instanceof String && this.authorName.length() > 0)) {
            throw new HttpError("Invalid book author name", HttpStatus.BAD_REQUEST);
        }
    }
}