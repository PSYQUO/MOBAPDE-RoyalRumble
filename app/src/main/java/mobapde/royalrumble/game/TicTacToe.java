package mobapde.royalrumble.game;

import android.widget.Toast;

/**
 * Created by Jords on 12/5/2017.
 */

public class TicTacToe extends Game{
    private Player player1, player2;
    private Board board;
    private boolean win;
    private boolean full;

    public TicTacToe(Player player1, Player player2){
        board = new Board(3, 3);
        win = false;
        full = false;
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player getTurn(int turn){
        if(turn == 1)
            return player1;
        else
            return player2;
    }

    public void setPiece(Player player, int x, int y){
        Piece piece = new Piece(player, "x", "black");
        //System.out.println("This:" + x + " " + y);
        //board.print();
        board.setPiece(piece, x, y);

        win = (checkWin(x, y));

        full = checkFull();


    }

    public void print(){
        board.print();
    }

    public Piece getPiece(int x, int y){
        return board.getPiece(x, y);
    }

    public boolean checkFull(){

        for(int i = 0; i < board.getSizex(); i++) {
            for (int j = 0; j < board.getSizey(); j++) {
                try {
                    if (board.getPiece(i, j).getPlayer() == null)
                        return false;
                } catch (NullPointerException e) {
                    return false;
            }
            }
        }

        return true;
    }

    public boolean checkWin(int x, int y) {

        int player = board.getPiece(x, y).getPlayer().getPnum();

        int ctr = 0;

        try {
            for (int n = 0; n < 3; n++) {
                if ((board.getPiece(x, n).getPlayer().getPnum() == player)) {
                    ctr++;
                }
            }
        }catch (NullPointerException e){
        }
        if(ctr == 3)
            return true;
        ctr = 0;
        try {
            for (int n = 0; n < 3; n++) {
                if ((board.getPiece(n, y).getPlayer().getPnum() == player))
                    ctr++;
            }
            if (ctr == 3)
                return true;
        }catch (NullPointerException e){
        }
        ctr = 0;

        try {
            for (int i = 0; i < 3; i++) {
                if ((board.getPiece(i, i).getPlayer().getPnum() == player))
                    ctr++;
            }
            if (ctr == 3)
                return true;
        }catch (NullPointerException e){
        }
        ctr = 0;

        try {
            for (int i = 0; i < 3; i++) {
                if ((board.getPiece(i, -1 * i + (3 - 1)).getPlayer().getPnum() == player))
                    ctr++;
            }
            if (ctr == 3)
                return true;
        }catch (NullPointerException e){
        }

        return false;
    }


    public boolean getWin(){
        return win;
    }

    public boolean getFull(){
        return full;
    }

}
