package com.chess.model;

import java.util.Scanner;

public class Player {
    String name;
    String color;
    Player(String name,String color)
    {
        this.color=color;
        this.name=name;
    }
    public int[] makeMove()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("x and y Cord of :");
        System.out.print("From : ");
        int fromXCord=sc.nextInt();
        int fromYCord=sc.nextInt();
        System.out.print("To : ");
        int toXCord=sc.nextInt();
        int toYCord=sc.nextInt();
        return new int[]{fromXCord,fromYCord,toXCord,toYCord};
    }

    public String getName() {
        return name;
    }
}
