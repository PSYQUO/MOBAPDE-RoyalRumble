package com.example.jords.mobapde_royalrumble;

import java.util.Scanner;

/**
 * Created by Jords on 11/6/2017.
 */

public class Game {
    Player player1, player2;

    public Game(){
        player1 = new Player(1, "Meruem");
        player2 = new Player(2, "Komugi");
    }

    public void playCheckers(){

        Checkers game = new Checkers(player1, player2);
        game.print();

        Scanner sc = new Scanner(System.in);

        int x, y, newx, newy;
        String check = null;

        while(true){
            x = 0;
            y = 0;

            System.out.println(player1.getName() + ": ");
            System.out.print("X = ");
            x = sc.nextInt();
            System.out.print("Y = ");
            y = sc.nextInt();
            System.out.print("newX = ");
            newx = sc.nextInt();
            System.out.print("newY = ");
            newy = sc.nextInt();

            check = game.checkMove(x, y, newx, newy, player1);

            if(check.equals("move"))
                game.move(x, y, newx, newy);
            else if(check.equals("attack"))
                game.attack(x, y, newx, newy);
            else
                System.out.println("Invalid Move "+ player1.getName() + "!!");

            game.print();

            System.out.println(player2.getName() + ": ");
            System.out.print("X = ");
            x = sc.nextInt();
            System.out.print("Y = ");
            y = sc.nextInt();
            System.out.print("newX = ");
            newx = sc.nextInt();
            System.out.print("newY = ");
            newy = sc.nextInt();

            check = game.checkMove(x, y, newx, newy, player2);

            if(check.equals("move"))
                game.move(x, y, newx, newy);
            else if(check.equals("attack"))
                game.attack(x, y, newx, newy);
            else
                System.out.println("Invalid Move "+ player2.getName() + "!!");

            game.print();
        }

    }

}
