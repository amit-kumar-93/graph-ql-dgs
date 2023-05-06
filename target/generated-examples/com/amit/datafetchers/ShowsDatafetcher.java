package com.amit.datafetchers;

import com.amit.types.Show;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;

@DgsComponent
public class ShowsDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "shows"
  )
  public List<Show> getShows(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
