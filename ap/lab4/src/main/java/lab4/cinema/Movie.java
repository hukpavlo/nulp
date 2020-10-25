package lab4.cinema;

import org.springframework.http.HttpStatus;

import java.util.UUID;

public class Movie {
    private final String id;
    private String name;
    private Integer rating;

    Movie(String name, int rating) {
        this.name = name;
        this.rating = rating;
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public Integer getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void validate() {
        boolean isNameValid = this.name instanceof String && this.name.length() != 0;
        boolean isRatingValid = this.rating instanceof Integer && this.rating >= 0 && this.rating <= 5;

        if (!isNameValid) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "Invalid name");
        }

        if (!isRatingValid) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "Invalid rating");
        }
    }
}