package com.amit;

import java.lang.String;

public class DgsConstants {
  public static final String QUERY_TYPE = "Query";

  public static class QUERY {
    public static final String TYPE_NAME = "Query";

    public static final String Shows = "shows";

    public static class SHOWS_INPUT_ARGUMENT {
      public static final String TitleFilter = "titleFilter";
    }
  }

  public static class SHOW {
    public static final String TYPE_NAME = "Show";

    public static final String Title = "title";

    public static final String ReleaseYear = "releaseYear";

    public static final String Reviews = "reviews";
  }

  public static class REVIEW {
    public static final String TYPE_NAME = "Review";

    public static final String StarRating = "starRating";
  }
}
