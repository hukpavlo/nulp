package lab4.cinema;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createMovie(@RequestBody Movie movie) {
        movie.validate();

        movieService.save(movie);
    }

    @GetMapping
    Movie[] getAllMovies() {
        return movieService.getAll();
    }

    @GetMapping("/{movieId}")
    Movie getMovieById(@PathVariable("movieId") String movieId) {
        return movieService.getById(movieId);
    }

    @PutMapping("/{movieId}")
    void updateMovieById(@PathVariable("movieId") String movieId, @RequestBody Movie movie) {
        movie.validate();

        movieService.updateById(movieId, movie);
    }

    @DeleteMapping("/{movieId}")
    void deleteMovieById(@PathVariable("movieId") String movieId) {
        movieService.deleteById(movieId);
    }
}
