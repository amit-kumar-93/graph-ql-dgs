package com.amit.types;

import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

public class Show {
  private String title;

  private Integer releaseYear;

  private List<Review> reviews;

  public Show() {
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(Integer releaseYear) {
    this.releaseYear = releaseYear;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }

  @Override
  public String toString() {
    return "Show{" + "title='" + title + "'," +"releaseYear='" + releaseYear + "'," +"reviews='" + reviews + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Show that = (Show) o;
        return java.util.Objects.equals(title, that.title) &&
                            java.util.Objects.equals(releaseYear, that.releaseYear) &&
                            java.util.Objects.equals(reviews, that.reviews);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(title, releaseYear, reviews);
  }

  public static com.amit.types.Show.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String title;

    private Integer releaseYear;

    private List<Review> reviews;

    public Show build() {
                  com.amit.types.Show result = new com.amit.types.Show();
                      result.title = this.title;
          result.releaseYear = this.releaseYear;
          result.reviews = this.reviews;
                      return result;
    }

    public com.amit.types.Show.Builder title(String title) {
      this.title = title;
      return this;
    }

    public com.amit.types.Show.Builder releaseYear(Integer releaseYear) {
      this.releaseYear = releaseYear;
      return this;
    }

    public com.amit.types.Show.Builder reviews(List<Review> reviews) {
      this.reviews = reviews;
      return this;
    }
  }
}
