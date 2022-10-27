package com.company.droids;

public class AttackerDroid extends Droid {
  private int countFatalities;
  private double fatalityDamage;

  public AttackerDroid(
      String name,
      double health,
      double damage,
      double precision,
      int countFatalities,
      double fatalityDamage) {
    super(name, health, damage, precision);
    this.countFatalities = countFatalities;
    this.fatalityDamage = fatalityDamage;
  }

  public double addDamage() {
    return countFatalities * fatalityDamage;
  }
}
