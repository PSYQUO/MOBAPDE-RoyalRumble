package mobapde.royalrumble;

import java.util.ArrayList;

/**
 * Created by Jords on 11/6/2017.
 */

public class Player {

    private int pnum;
    private String name;

    public Player(int pnum, String name){
        this.pnum = pnum;
        this.name = name;
    }

    public int getPnum() {
        return pnum;
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
