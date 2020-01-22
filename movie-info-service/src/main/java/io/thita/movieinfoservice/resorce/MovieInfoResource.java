package io.thita.movieinfoservice.resorce;

import io.thita.movieinfoservice.model.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieInfoResource {

    @RequestMapping("/{movieId}")
    private Movie getMovieInfo(@PathVariable("movieId") String movieId){
        return new Movie(movieId, "Name of Movie id " + movieId + " is Lost in space");
    }

}
