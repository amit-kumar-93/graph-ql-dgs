package com.amit.server.types;

import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

public class Show {
  private String title;

  private Integer releaseYear;

  private List<Review> reviews;

  private List<Director> directors;

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

  public List<Director> getDirectors() {
    return directors;
  }

  public void setDirectors(List<Director> directors) {
    this.directors = directors;
  }

  @Override
  public String toString() {
    return "Show{" + "title='" + title + "'," +"releaseYear='" + releaseYear + "'," +"reviews='" + reviews + "'," +"directors='" + directors + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Show that = (Show) o;
        return java.util.Objects.equals(title, that.title) &&
                            java.util.Objects.equals(releaseYear, that.releaseYear) &&
                            java.util.Objects.equals(reviews, that.reviews) &&
                            java.util.Objects.equals(directors, that.directors);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(title, releaseYear, reviews, directors);
  }

  public static com.amit.server.types.Show.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String title;

    private Integer releaseYear;

    private List<Review> reviews;

    private List<Director> directors;

    public Show build() {
                  com.amit.server.types.Show result = new com.amit.server.types.Show();
                      result.title = this.title;
          result.releaseYear = this.releaseYear;
          result.reviews = this.reviews;
          result.directors = this.directors;
                      return result;
    }

    public com.amit.server.types.Show.Builder title(String title) {
      this.title = title;
      return this;
    }

    public com.amit.server.types.Show.Builder releaseYear(Integer releaseYear) {
      this.releaseYear = releaseYear;
      return this;
    }

    public com.amit.server.types.Show.Builder reviews(List<Review> reviews) {
      this.reviews = reviews;
      return this;
    }

    public com.amit.server.types.Show.Builder directors(List<Director> directors) {
      this.directors = directors;
      return this;
    }
  }
}
