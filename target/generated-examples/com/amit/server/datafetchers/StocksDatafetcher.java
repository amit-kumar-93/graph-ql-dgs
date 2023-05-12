package com.amit.server.datafetchers;

import com.amit.server.types.Stock;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;

@DgsComponent
public class StocksDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "stocks"
  )
  public Stock getStocks(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}