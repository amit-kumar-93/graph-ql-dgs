package com.amit.server.types;

import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class Stock {
  private String name;

  private Double price;

  public Stock() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Stock{" + "name='" + name + "'," +"price='" + price + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock that = (Stock) o;
        return java.util.Objects.equals(name, that.name) &&
                            java.util.Objects.equals(price, that.price);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(name, price);
  }

  public static com.amit.server.types.Stock.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String name;

    private Double price;

    public Stock build() {
                  com.amit.server.types.Stock result = new com.amit.server.types.Stock();
                      result.name = this.name;
          result.price = this.price;
                      return result;
    }

    public com.amit.server.types.Stock.Builder name(String name) {
      this.name = name;
      return this;
    }

    public com.amit.server.types.Stock.Builder price(Double price) {
      this.price = price;
      return this;
    }
  }
}
