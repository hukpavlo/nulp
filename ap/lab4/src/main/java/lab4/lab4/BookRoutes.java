package lab4.lab4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookRoutes {
    @Autowired
    private BookMethods bookMethods;

    @PostMapping
    void create(@RequestBody Book book) {
        bookMethods.createNew(book);
    }

    @GetMapping
    Book[] getAll() {
        return bookMethods.getAll();
    }

    @GetMapping("/{itemId}")
    Book getById(@PathVariable("itemId") String itemId) {
        return bookMethods.getById(itemId);
    }

    @PutMapping("/{itemId}")
    void updateById(@PathVariable("itemId") String itemId, @RequestBody Book book) {
        bookMethods.updateById(itemId, book);
    }

    @DeleteMapping("/{itemId}")
    void deleteById(@PathVariable("itemId") String itemId) {
        bookMethods.deleteById(itemId);
    }
}
