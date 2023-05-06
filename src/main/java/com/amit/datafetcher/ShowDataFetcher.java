package com.amit.datafetcher;

import com.amit.service.ShowService;
import com.amit.types.Show;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;


@DgsComponent
public class ShowDataFetcher {
    @Autowired
    ShowService showsService;

    @DgsQuery
    public List<Show> shows(@InputArgument String titleFilter) {
        List<Show> shows=showsService.shows();
        if (titleFilter != null) {
            return shows.stream().filter(show -> show.getTitle().startsWith(titleFilter)).collect(Collectors.toList());
        }
        return shows;
    }
}