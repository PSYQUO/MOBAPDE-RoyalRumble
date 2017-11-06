package com.example.jords.mobapde_royalrumble;

import android.graphics.Color;

/**
 * Created by Jords on 11/6/2017.
 */

public class Piece {
    private Player player;
    private String type;
    private String color;

    public Piece(Player player, String type, String color){
        this.player = player;
        this.type = type;
        this.color = color;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
