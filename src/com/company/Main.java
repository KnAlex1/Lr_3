package com.company;

import com.company.areas.Area;
import com.company.areas.Area3D;
import com.company.droids.AttackerDroid;
import com.company.droids.Droid;
import com.company.droids.HelperDroid;
import com.company.fights.CommandFight;
import com.company.fights.SingleFight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    List<Droid> droids = new ArrayList<>();
    int operation = -1;
    System.out.println("---Fight of Droids---");
    while (operation != 5) {
      System.out.println("---------------------------");
      System.out.println("Enter 1 to create new Droid");
      System.out.println("Enter 2 to show all Droids");
      System.out.println("Enter 3 to run SingleFight");
      System.out.println("Enter 4 to run CommandFight");
      System.out.println("Enter 5 to exit program");
      System.out.println("------------------------");
      operation = in.nextInt();
      if (operation == 1) {
        System.out.println("Creating new Droid");
        System.out.println("Select type");
        System.out.println("Droid - 1 | HelperDroid - 2 | AttackerDroid - 3");
        int type = in.nextInt();
        in.nextLine();
        System.out.println("Enter name: ");
        String name = in.nextLine();
        System.out.print("Enter health: ");
        double health = in.nextDouble();
        System.out.print("Enter damage: ");
        double damage = in.nextDouble();
        System.out.print("Enter precision: ");
        double precision = in.nextDouble();
        if (type == 1) {
          Droid droid = new Droid(name, health, damage, precision);
          droids.add(droid);
        }
        if (type == 2) {
          System.out.print("Enter count of Helps: ");
          int countOfHelps = in.nextInt();
          System.out.print("Enter value of Helps: ");
          double valueHelp = in.nextDouble();
          HelperDroid helperDroid =
              new HelperDroid(name, health, damage, precision, countOfHelps, valueHelp);
          droids.add(helperDroid);
        } else if (type == 3) {
          System.out.print("Enter count of Fatalities: ");
          int countFatalities = in.nextInt();
          System.out.print("Enter value of Fatality: ");
          double valueFatality = in.nextDouble();
          AttackerDroid attackerDroid =
              new AttackerDroid(name, health, damage, precision, countFatalities, valueFatality);
          droids.add(attackerDroid);
        }
      } else if (operation == 2) {
        for (int i = 0; i < droids.size(); i++) {
          Droid droid = droids.get(i);
          System.out.print("#" + i + " name = " + droid.getName() + " type = ");
          if (droid instanceof HelperDroid) System.out.println("HelperDroid");
          else if (droid instanceof AttackerDroid) System.out.println("AttackerDroid");
          else System.out.println("Droid");
        }
      } else if (operation == 3) {
        System.out.print("Select left Droid from list: ");
        int leftIndex = in.nextInt();
        System.out.print("Select right Droid from list: ");
        int rightIndex = in.nextInt();
        System.out.println("Select area");
        System.out.println("Area - 1 | Area3D - 2");
        int type = in.nextInt();
        Area area;
        if (type == 1) area = new Area(1000, 100, 1);
        else area = new Area3D(1000, 1000, 1000, 0.95);
        SingleFight singleFight =
            new SingleFight(area, droids.get(leftIndex), droids.get(rightIndex));
        singleFight.fight();
      } else if (operation == 4) {
        List<Droid> leftDroids = new ArrayList<>();
        List<Droid> rightDroids = new ArrayList<>();
        System.out.print("Enter size of left team: ");
        int leftSize = in.nextInt();
        System.out.print("Enter size of right team: ");
        int rightSize = in.nextInt();
        System.out.println("Enter indexes of left team");
        for (int i = 0; i < leftSize; i++) {
          leftDroids.add(droids.get(in.nextInt()));
        }
        System.out.println("Enter indexes of right team");
        for (int i = 0; i < rightSize; i++) {
          rightDroids.add(droids.get(in.nextInt()));
        }
        System.out.println("Select area");
        System.out.println("Area - 1 | Area3D - 2");
        int type = in.nextInt();
        Area area;
        if (type == 1) area = new Area(1000, 100, 1);
        else area = new Area3D(1000, 1000, 1000, 0.95);
        CommandFight commandFight = new CommandFight(area, leftDroids, rightDroids);
        commandFight.fight();
      } else if (operation == 5) {
        break;
      }
    }
  }
}
