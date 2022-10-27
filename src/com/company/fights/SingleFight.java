package com.company.fights;

import com.company.areas.Area;
import com.company.droids.AttackerDroid;
import com.company.droids.Droid;
import com.company.droids.HelperDroid;

public class SingleFight {
  private Area area;
  private Droid leftDroid;
  private Droid rightDroid;
  private double leftDroidTotalHealth;
  private double leftDroidTotalDamage;
  private double rightDroidTotalHealth;
  private double rightDroidTotalDamage;

  public SingleFight(Area area, Droid leftDroid, Droid rightDroid) {
    this.area = area;
    this.leftDroid = leftDroid;
    this.rightDroid = rightDroid;
  }

  private void prepareDroids() {
    // Left droid
    leftDroidTotalHealth = leftDroid.getHealth();
    leftDroidTotalDamage = leftDroid.getDamage();
    if (leftDroid instanceof HelperDroid) {
      leftDroidTotalHealth += ((HelperDroid) leftDroid).addHealth();
    }
    if (leftDroid instanceof AttackerDroid) {
      leftDroidTotalDamage += ((AttackerDroid) leftDroid).addDamage();
    }
    leftDroidTotalDamage *= leftDroid.getPrecision();
    leftDroidTotalDamage *= area.getAreaPrecision();
    // Right droid
    rightDroidTotalHealth = rightDroid.getHealth();
    rightDroidTotalDamage = rightDroid.getDamage();
    if (rightDroid instanceof HelperDroid) {
      rightDroidTotalDamage += ((HelperDroid) rightDroid).addHealth();
    }
    if (rightDroid instanceof AttackerDroid) {
      rightDroidTotalDamage += ((AttackerDroid) rightDroid).addDamage();
    }
    rightDroidTotalDamage *= rightDroid.getPrecision();
    rightDroidTotalDamage *= area.getAreaPrecision();
  }

  public void fight() {
    prepareDroids();
    leftDroidTotalHealth -= rightDroidTotalDamage;
    rightDroidTotalHealth -= leftDroidTotalDamage;
    if (leftDroidTotalHealth > rightDroidTotalHealth) printWinner(true);
    else printWinner(false);
  }

  public void printWinner(boolean winner) {
    if (winner) System.out.println("Left droid with name " + leftDroid.getName() + " is winner!");
    else System.out.println("Right droid with name " + rightDroid.getName() + " is winner!");
  }
}
