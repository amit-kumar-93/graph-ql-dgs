package com.amit.types;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;

public class Subscription {
  private Stock stocks;

  public Subscription() {
  }

  public Stock getStocks() {
    return stocks;
  }

  public void setStocks(Stock stocks) {
    this.stocks = stocks;
  }

  @Override
  public String toString() {
    return "Subscription{" + "stocks='" + stocks + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return java.util.Objects.equals(stocks, that.stocks);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(stocks);
  }

  public static com.amit.types.Subscription.Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private Stock stocks;

    public Subscription build() {
      com.amit.types.Subscription result = new com.amit.types.Subscription();
          result.stocks = this.stocks;
          return result;
    }

    public com.amit.types.Subscription.Builder stocks(Stock stocks) {
      this.stocks = stocks;
      return this;
    }
  }
}
