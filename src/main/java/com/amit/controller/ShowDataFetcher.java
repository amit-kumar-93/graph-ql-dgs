package com.amit.controller;

import com.amit.types.Review;
import com.amit.types.Show;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@DgsComponent
public class ShowDataFetcher {

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
            Show.newBuilder().title("Stranger Things").releaseYear(2016).reviews(sThingReviews).build(),
            Show.newBuilder().title("Milano").releaseYear(2015).reviews(Milano).build()
    );


    @DgsQuery
    public List<Show> shows(@InputArgument String titleFilter) {
        if (titleFilter != null) {
            return shows.stream().filter(show -> show.getTitle().startsWith(titleFilter)).collect(Collectors.toList());
        }
        return shows;
    }
}