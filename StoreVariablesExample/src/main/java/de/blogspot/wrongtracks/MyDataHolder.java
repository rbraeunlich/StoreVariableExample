package de.blogspot.wrongtracks;

public class MyDataHolder {

  private final String data;

  public MyDataHolder(String data) {
    this.data = data;
  }

  public String getData() {
    return data;
  }

  @Override
  public String toString() {
    return data;
  }

}
