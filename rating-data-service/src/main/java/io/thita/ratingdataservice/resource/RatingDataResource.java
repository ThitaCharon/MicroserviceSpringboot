package io.thita.ratingdataservice.resource;

import io.thita.ratingdataservice.model.Rating;
import io.thita.ratingdataservice.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/ratingsdata")
public class RatingDataResource {

    @RequestMapping("/{movieId}")
    public Rating getMovieRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId, 5);
    };

    @RequestMapping("/user/{userId}")
    public UserRating getUserRateing(@PathVariable("userId") String userId){
        UserRating userRating = new UserRating();
        userRating.initData(userId);
        return userRating;
    }
}
