package com.example.jords.mobapde_royalrumble;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jords on 11/6/2017.
 */

public class Board {
    private ArrayList<ArrayList<Piece>> board;
    private int sizex, sizey;

    public Board(int sizex, int sizey){
        this.sizex = sizex;
        this.sizey = sizey;
        board = new ArrayList<ArrayList<Piece>>(sizex);

        for (int i = 0; i < sizex; i++)
            board.add(new ArrayList<Piece>(sizey));

    }

    public void print(){
        for(int x = 0; x < sizex; x++){
            for (int y = 0; y < sizey; y++){
                if(board.get(x).get(y) == null)
                    System.out.print("O ");
                if(board.get(x).get(y) != null)
                    System.out.print("X");
            }
            System.out.println();
        }
    }

    public void setPiece(Piece piece, int x, int y){
        System.out.println("fdasf");
        board.get(x).set(y, piece);
    }

    public ArrayList<ArrayList<Piece>> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<ArrayList<Piece>> board) {
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
