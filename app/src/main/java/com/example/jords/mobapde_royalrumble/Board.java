package com.example.jords.mobapde_royalrumble;

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
        for(int x = 0; x < sizex; x++){
            for (int y = 0; y < sizey; y++){
                if(board.get(x).get(y).getPiece() == null)
                    System.out.print("O ");
                else if(board.get(x).get(y).getPiece() != null)
                    System.out.print("X ");
            }
            System.out.println();
        }
    }

    public void setPiece(Piece piece, int x, int y){
        board.get(x).get(y).setPiece(piece);
    }

    public Piece getPiece(int x, int y){
        Piece piece = board.get(x).get(y).getPiece();
        board.get(x).get(y).removePiece();
        return piece;
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
