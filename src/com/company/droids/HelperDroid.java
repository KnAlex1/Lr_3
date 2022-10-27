package com.company.droids;

public class HelperDroid extends Droid {
  private int countHelps;
  private double valueOFHelp;

  public HelperDroid(
      String name,
      double health,
      double damage,
      double precision,
      int countHelps,
      double valueOFHelp) {
    super(name, health, damage, precision);
    this.countHelps = countHelps;
    this.valueOFHelp = valueOFHelp;
  }

  public double addHealth() {
    return countHelps * valueOFHelp;
  }
}
