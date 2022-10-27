package com.company.droids;

public class Droid {
  private String name;
  private double health;
  private double damage;
  private double precision;

  public Droid() {}

  public Droid(String name, double health, double damage, double precision) {
    this.name = name;
    this.health = health;
    this.damage = damage;
    this.precision = precision;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getHealth() {
    return health;
  }

  public void setHealth(double health) {
    this.health = health;
  }

  public double getDamage() {
    return damage;
  }

  public void setDamage(double damage) {
    this.damage = damage;
  }

  public double getPrecision() {
    return precision;
  }

  public void setPrecision(double precision) {
    this.precision = precision;
  }
}
