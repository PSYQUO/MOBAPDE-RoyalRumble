package mobapde.royalrumble;

/**
 * Created by Jords on 11/6/2017.
 */

public class Tile
{
    private Piece piece;

    public Tile()
    {
        piece = null;
    }

    public Piece getPiece()
    {
        return piece;
    }

    public void setPiece(Piece piece){
        this.piece = piece;
    }

    public void removePiece()
    {
        this.piece = null;
    }
}
