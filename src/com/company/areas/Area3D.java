package com.company.areas;

public class Area3D extends Area {
  private int height;

  public Area3D(int length, int weight, int height, double areaPrecision) {
    super(length, weight, areaPrecision);
    this.height = height;
  }
}
