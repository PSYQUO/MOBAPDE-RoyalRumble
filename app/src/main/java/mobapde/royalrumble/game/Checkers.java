package mobapde.royalrumble.game;

import android.widget.LinearLayout;

import static java.lang.Math.abs;

/**
 * Created by Jords on 11/15/2017.
 */

public class Checkers {

    private Board board;
    private final static int SIZEX = 8;
    private final static int SIZEY = 8;
    private Player player1, player2;

    LinearLayout gridView;


    public Checkers(Player player1, Player player2)
    {
        board = new Board(SIZEX, SIZEY);
        this.player1 = player1;
        this.player2 = player2;
    }


    public void print()
    {
        board.print();
    }

    public String checkMove(int initX, int initY, int newX, int newY, Player player)
    {
        int tempX = abs(initX - newX);
        int tempY = abs(initY - newY);

        if(player.getPnum() == board.getBoard().get(initX).get(initY).getPiece().getPlayer().getPnum())
        {
            if(tempX == 1 && tempY == 1)
            {
                if(!board.isTherePiece(newX, newY))
                    return "move";
            }
            else if(tempX == 2 && tempY == 2)
            {
                if(!board.isTherePiece(abs(initX - newX), abs(initY - newY)))
                {
                    return "attack";
                }
            }
        }

        return "none";
    }

    public void attack(int initX, int initY, int newX, int newY)
    {
        //Piece temp = board.getPiece(initX, initY);
        //board.removePiece(abs(initX-newX), abs(initY-newY));
        board.setPiece(board.getPiece(initX, initY), newX, newY);
    }

    public void move(int initX, int initY, int newX, int newY)
    {
//        Piece temp = board.getPiece(initX, initY);
        board.setPiece(board.getPiece(initX, initY), newX, newY);
    }

    public void setUp()
    {
        board.setPiece(new Piece(player1, "checkers", "black"), 0, 1);
        board.setPiece(new Piece(player1, "checkers", "black"), 0, 3);
        board.setPiece(new Piece(player1, "checkers", "black"), 0, 5);
        board.setPiece(new Piece(player1, "checkers", "black"), 0, 7);
        board.setPiece(new Piece(player1, "checkers", "black"), 1, 0);
        board.setPiece(new Piece(player1, "checkers", "black"), 1, 2);
        board.setPiece(new Piece(player1, "checkers", "black"), 1, 4);
        board.setPiece(new Piece(player1, "checkers", "black"), 1, 6);
//        board.setPiece(new Piece(player1, "checkers", "black"), 2, 1);
        board.setPiece(new Piece(player1, "checkers", "black"), 3, 0);
        board.setPiece(new Piece(player1, "checkers", "black"), 2, 3);
        board.setPiece(new Piece(player1, "checkers", "black"), 2, 5);
        board.setPiece(new Piece(player1, "checkers", "black"), 2, 7);

        board.setPiece(new Piece(player2, "checkers", "black"), 5, 0);
        board.setPiece(new Piece(player2, "checkers", "black"), 4, 1);
//        board.setPiece(new Piece(player2, "checkers", "black"), 5, 2);
        board.setPiece(new Piece(player2, "checkers", "black"), 5, 4);
        board.setPiece(new Piece(player2, "checkers", "black"), 5, 6);
        board.setPiece(new Piece(player2, "checkers", "black"), 6, 1);
        board.setPiece(new Piece(player2, "checkers", "black"), 6, 3);
        board.setPiece(new Piece(player2, "checkers", "black"), 6, 5);
        board.setPiece(new Piece(player2, "checkers", "black"), 6, 7);
        board.setPiece(new Piece(player2, "checkers", "black"), 7, 0);
        board.setPiece(new Piece(player2, "checkers", "black"), 7, 2);
        board.setPiece(new Piece(player2, "checkers", "black"), 7, 4);
        board.setPiece(new Piece(player2, "checkers", "black"), 7, 6);
    }
}
