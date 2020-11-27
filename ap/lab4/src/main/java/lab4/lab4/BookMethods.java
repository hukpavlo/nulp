package lab4.lab4;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;

@Service
public class BookMethods {
    private ArrayList<Book> currentBooks = new ArrayList<>();

    public void createNew(Book book) {
        book.validate();
        currentBooks.add(book);
    }

    public Book[] getAll() {
        return currentBooks.toArray(new Book[currentBooks.size()]);
    }

    public Book getById(String itemId) {
        for(Book book : currentBooks) {
            if(book.getItemId().equals(itemId)) {
                return book;
            }
        }

        throw new HttpError("No book found", HttpStatus.BAD_REQUEST);
    }

    public void updateById(String itemId, Book updatedBook) {
        Book book = this.getById(itemId);

        book.setPrice(updatedBook.getPrice());
    }

    public Book deleteById(String itemId) {
        for(int i = 0; i < currentBooks.size(); i++) {
            if(currentBooks.get(i).getItemId().equals(itemId)) {
                return currentBooks.remove(i);
            }
        }

        throw new HttpError( "No book found", HttpStatus.BAD_REQUEST);
    }
}
