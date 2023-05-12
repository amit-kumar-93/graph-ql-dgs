package com.amit.server.types;

import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class Review {
  private Integer starRating;

  public Review() {
  }

  public Integer getStarRating() {
    return starRating;
  }

  public void setStarRating(Integer starRating) {
    this.starRating = starRating;
  }

  @Override
  public String toString() {
    return "Review{" + "starRating='" + starRating + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review that = (Review) o;
        return java.util.Objects.equals(starRating, that.starRating);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(starRating);
  }

  public static com.amit.server.types.Review.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private Integer starRating;

    public Review build() {
      com.amit.server.types.Review result = new com.amit.server.types.Review();
          result.starRating = this.starRating;
          return result;
    }

    public com.amit.server.types.Review.Builder starRating(Integer starRating) {
      this.starRating = starRating;
      return this;
    }
  }
}
