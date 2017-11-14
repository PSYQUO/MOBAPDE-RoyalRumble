package mobapde.royalrumble;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Scanner;

/**
 * Created by Jords on 11/6/2017.
 */

public class Game extends AppCompatActivity
{
    Player player1, player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.checkers);

        PixelGridView pixelGrid = new PixelGridView(this);
        pixelGrid.setNumColumns(10);
        pixelGrid.setNumRows(10);
        setContentView(pixelGrid);

        player1 = new Player(1, "Meruem");
        player2 = new Player(2, "Komugi");

//        String game = getIntent().getExtras().getInt(game);

    }

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
