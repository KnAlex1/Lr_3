package com.company.areas;

public class Area {
  private int length;
  private int weight;
  private double areaPrecision;

  public Area(int length, int weight, double areaPrecision) {
    this.length = length;
    this.weight = weight;
    this.areaPrecision = areaPrecision;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public double getAreaPrecision() {
    return areaPrecision;
  }

  public void setAreaPrecision(int areaPrecision) {
    this.areaPrecision = areaPrecision;
  }
}
