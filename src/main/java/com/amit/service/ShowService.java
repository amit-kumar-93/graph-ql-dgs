package com.amit.service;

import com.amit.types.Review;
import com.amit.types.Show;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ShowService {

    private List<Review> oarkReviews = Arrays.asList(
            Review.newBuilder().starRating(5).build(),
            Review.newBuilder().starRating(4).build(),
            Review.newBuilder().starRating(4).build(),
            Review.newBuilder().starRating(3).build()
    );
    private List<Review> sThingReviews = Arrays.asList(
            Review.newBuilder().starRating(5).build(),
            Review.newBuilder().starRating(4).build(),
            Review.newBuilder().starRating(2).build(),
            Review.newBuilder().starRating(3).build()
    );
    private List<Review> Milano = Arrays.asList(
            Review.newBuilder().starRating(5).build(),
            Review.newBuilder().starRating(2).build(),
            Review.newBuilder().starRating(2).build(),
            Review.newBuilder().starRating(1).build()
    );

    private List<Show> shows = Arrays.asList(
            Show.newBuilder().title("Ozarks").releaseYear(2017).reviews(oarkReviews).build(),
            Show.newBuilder().title("Orange is the new Black").releaseYear(2018).reviews(oarkReviews).build(),
            Show.newBuilder().title("Oaths Not Taken").releaseYear(2018).reviews(oarkReviews).build(),
            Show.newBuilder().title("Star Trek").releaseYear(1998).reviews(oarkReviews).build(),
            Show.newBuilder().title("Stranger Things").releaseYear(2016).reviews(sThingReviews).build(),
            Show.newBuilder().title("Milano").releaseYear(2015).reviews(Milano).build()
    );

    public List<Show> shows() {
        return shows;
    }
}