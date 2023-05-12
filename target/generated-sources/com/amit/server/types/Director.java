package com.amit.server.types;

import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class Director {
  private String name;

  private Integer rating;

  private Integer showsDirected;

  public Director() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  public Integer getShowsDirected() {
    return showsDirected;
  }

  public void setShowsDirected(Integer showsDirected) {
    this.showsDirected = showsDirected;
  }

  @Override
  public String toString() {
    return "Director{" + "name='" + name + "'," +"rating='" + rating + "'," +"showsDirected='" + showsDirected + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director that = (Director) o;
        return java.util.Objects.equals(name, that.name) &&
                            java.util.Objects.equals(rating, that.rating) &&
                            java.util.Objects.equals(showsDirected, that.showsDirected);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(name, rating, showsDirected);
  }

  public static com.amit.server.types.Director.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String name;

    private Integer rating;

    private Integer showsDirected;

    public Director build() {
                  com.amit.server.types.Director result = new com.amit.server.types.Director();
                      result.name = this.name;
          result.rating = this.rating;
          result.showsDirected = this.showsDirected;
                      return result;
    }

    public com.amit.server.types.Director.Builder name(String name) {
      this.name = name;
      return this;
    }

    public com.amit.server.types.Director.Builder rating(Integer rating) {
      this.rating = rating;
      return this;
    }

    public com.amit.server.types.Director.Builder showsDirected(Integer showsDirected) {
      this.showsDirected = showsDirected;
      return this;
    }
  }
}
