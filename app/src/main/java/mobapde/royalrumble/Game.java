package mobapde.royalrumble;

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

            if(game.checkMove(x, y, newx, newy, player1))
                game.move(x, y, newx, newy);
            else
                System.out.println("Invalid Move "+ player1.getName() + "!!");

            System.out.println(player2.getName() + ": ");
            System.out.print("X = ");
            x = sc.nextInt();
            System.out.print("Y = ");
            y = sc.nextInt();
            System.out.print("newX = ");
            newx = sc.nextInt();
            System.out.print("newY = ");
            newy = sc.nextInt();

            if(game.checkMove(x, y, newx, newy, player2))
                game.move(x, y, newx, newy);
            else
                System.out.println("Invalid Move "+ player2.getName() +"!!");

            game.print();
        }

    }

}
