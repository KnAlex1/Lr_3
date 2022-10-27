package com.company.fights;

import com.company.areas.Area;
import com.company.droids.AttackerDroid;
import com.company.droids.Droid;
import com.company.droids.HelperDroid;

import java.util.List;

public class CommandFight {
  private Area area;
  private List<Droid> leftDroids;
  private List<Droid> rightDroids;
  private double leftDroidsTotalHealth;
  private double leftDroidsTotalDamage;
  private double rightDroidsTotalHealth;
  private double rightDroidsTotalDamage;

  public CommandFight(Area area, List<Droid> leftDroids, List<Droid> rightDroids) {
    this.area = area;
    this.leftDroids = leftDroids;
    this.rightDroids = rightDroids;
  }

  private void prepareDroids() {
    // Left droids
    leftDroidsTotalHealth = 0;
    leftDroidsTotalDamage = 0;
    for (int i = 0; i < leftDroids.size(); i++) {
      leftDroidsTotalHealth += leftDroids.get(i).getHealth();
      leftDroidsTotalDamage += leftDroids.get(i).getDamage();
      if (leftDroids.get(i) instanceof HelperDroid) {
        leftDroidsTotalHealth += ((HelperDroid) leftDroids.get(i)).addHealth();
      }
      if (leftDroids.get(i) instanceof AttackerDroid) {
        leftDroidsTotalDamage += ((AttackerDroid) leftDroids.get(i)).addDamage();
      }
      leftDroidsTotalDamage *= leftDroids.get(i).getPrecision();
    }
    leftDroidsTotalDamage *= area.getAreaPrecision();
    // Right droid
    rightDroidsTotalHealth = 0;
    rightDroidsTotalDamage = 0;
    for (int i = 0; i < rightDroids.size(); i++) {
      rightDroidsTotalHealth += rightDroids.get(i).getHealth();
      rightDroidsTotalDamage += rightDroids.get(i).getDamage();
      if (rightDroids.get(i) instanceof HelperDroid) {
        rightDroidsTotalHealth += ((HelperDroid) rightDroids.get(i)).addHealth();
      }
      if (rightDroids.get(i) instanceof AttackerDroid) {
        rightDroidsTotalDamage += ((AttackerDroid) rightDroids.get(i)).addDamage();
      }
      rightDroidsTotalDamage *= rightDroids.get(i).getPrecision();
    }
    rightDroidsTotalDamage *= area.getAreaPrecision();
  }

  public void fight() {
    prepareDroids();
    leftDroidsTotalHealth -= rightDroidsTotalDamage;
    rightDroidsTotalHealth -= leftDroidsTotalDamage;
    if (leftDroidsTotalHealth > rightDroidsTotalHealth) printWinner(true);
    else printWinner(false);
  }

  public void printWinner(boolean winner) {
    if (winner) System.out.println("Left team of droids is winner!");
    else System.out.println("Right team of droids is winner!");
  }
}
