package com.example.jords.mobapde_royalrumble;

/**
 * Created by Jords on 11/6/2017.
 */

public class Game {
    Player player1, player2;


    public Game(){
        Player player1 = new Player(1, "Jordan");
        Player player2 = new Player(2, "Jose");
    }

    public void playCheckers(){
        Checkers game = new Checkers(player1, player2);
        game.print();

    }

}
