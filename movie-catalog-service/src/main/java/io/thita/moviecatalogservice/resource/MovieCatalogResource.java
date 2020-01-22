package io.thita.moviecatalogservice.resource;

import io.thita.moviecatalogservice.model.CatalogItems;
import io.thita.moviecatalogservice.model.Movie;
import io.thita.moviecatalogservice.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
   public List<CatalogItems> getCatalog(@PathVariable("userId")  String userId){
        //get all rated movie ids
        // foreach id -> call movie info service
        // pull them all together
        // Using RestTemplate passing the Url and the class which exact the same

        //Movie movie = restTemplate.getForObject("http://localhost:8082/movie/323", Movie.class);

        List<Rating> ratings = Arrays.asList(new Rating("m554", 5),
                                            new Rating("m555", 3),
                                            new Rating("m556" , 2));


        // loop through all rating and get the movie's info and then pull it together as a list
        return ratings.stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://localhost:8082/movie/" + rating.getMovieId() , Movie.class);
            return  new CatalogItems(movie.getName(), " Description ->" , rating.getRating());
        }).collect(Collectors.toList());
   }
}
