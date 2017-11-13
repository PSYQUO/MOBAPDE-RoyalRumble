package mobapde.royalrumble;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jords on 11/6/2017.
 */

public class Board {
    private ArrayList<ArrayList<Tile>> board;
    private int sizex, sizey;

    public Board(int sizex, int sizey){
        this.sizex = sizex;
        this.sizey = sizey;
        board = new ArrayList<ArrayList<Tile>>();

        for (int i = 0; i < sizex; i++) {
            ArrayList<Tile> x = new ArrayList<Tile>();
            for(int j = 0; j < sizey; j++)
                x.add(new Tile());
            board.add(x);
        }

    }

    public void print(){

        System.out.print("  ");
        for (int x = 0; x < sizex; x++)
            System.out.print(x + " ");

        System.out.println();

        for(int x = 0; x < sizex; x++){
            System.out.print(x + " ");
            for (int y = 0; y < sizey; y++){
                if(board.get(x).get(y).getPiece() == null) {
                    //you can use type as the avatar of the piece
                    System.out.print("- ");
                } else if(board.get(x).get(y).getPiece() != null) {
                    //you can use type as the avatar of the piece
                    if(board.get(x).get(y).getPiece().getPlayer().getPnum() == 1)
                        System.out.print("O ");
                    if(board.get(x).get(y).getPiece().getPlayer().getPnum() == 2)
                        System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    public void setPiece(Piece piece, int x, int y){
        board.get(x).get(y).setPiece(piece);
    }

    public Piece getPiece(int x, int y){
        System.out.println(x + " " + y);
        Piece piece = board.get(x).get(y).getPiece();
        board.get(x).get(y).removePiece();
        return piece;
    }

    public void removePiece(int x, int y){
        board.get(x).get(y).removePiece();
    }

    public boolean isTherePiece(int x, int y){
        if(board.get(x).get(y).getPiece() == null)
            return false;
        return true;
    }

    public ArrayList<ArrayList<Tile>> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<ArrayList<Tile>> board) {
        this.board = board;
    }

    public int getSizex() {
        return sizex;
    }

    public void setSizex(int sizex) {
        this.sizex = sizex;
    }

    public int getSizey() {
        return sizey;
    }

    public void setSizey(int sizey) {
        this.sizey = sizey;
    }
}
