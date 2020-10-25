package lab4.cinema;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieService {
    private ArrayList<Movie> movies = new ArrayList<>();

    public void save(Movie movie) {
        movies.add(movie);
    }

    public Movie[] getAll() {
        return movies.toArray(new Movie[movies.size()]);
    }

    public Movie getById(String id) {
        for(Movie movie : movies) {
            if(movie.getId().equals(id)) {
                return movie;
            }
        }

        throw new HttpException(HttpStatus.BAD_REQUEST, "No movie with id: " + id + " exists");
    }

    public void updateById(String id, Movie updatedMovie) {
        Movie movie = this.getById(id);

        movie.setName(updatedMovie.getName());
        movie.setRating(updatedMovie.getRating());
    }

    public Movie deleteById(String id) {
        for(int i = 0; i < movies.size(); i++) {
            if(movies.get(i).getId().equals(id)) {
                return movies.remove(i);
            }
        }

        throw new HttpException(HttpStatus.BAD_REQUEST, "No movie with id: " + id + " exists");
    }
}
