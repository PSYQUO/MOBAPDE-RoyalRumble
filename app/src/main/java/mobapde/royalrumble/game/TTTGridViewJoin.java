package mobapde.royalrumble.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import mobapde.royalrumble.R;
import mobapde.royalrumble.TicTacToeLocalActivity;
import mobapde.royalrumble.firebase.FirebaseConnection;

/**
 * Created by Jords on 11/12/2017.
 */

public class TTTGridViewJoin extends View {
    private int numColumns, numRows;
    private int cellWidth, cellHeight;
    private Paint blackPaint = new Paint();
    private boolean[][] cellChecked;
    private Player player;
    private int turn;
    private TicTacToe tictactoe;
    private int x_place, y_place;

    DatabaseReference dr;

    Drawable x, o;

    public TTTGridViewJoin(Context context, TicTacToe ticTacToe) {
        this(context, ticTacToe, null);
    }

    public TTTGridViewJoin(Context context, final TicTacToe ticTacToe, AttributeSet attrs) {
        super(context, attrs);
        blackPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        x = getResources().getDrawable(R.drawable.x);
        o = getResources().getDrawable(R.drawable.o);

        tictactoe = ticTacToe;

        dr = FirebaseConnection.getInstance().getReference();



        dr.child("tictactoe").child("player1pieces").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    int x = Integer.parseInt(dataSnapshot.child("x").getValue().toString());
                    int y = Integer.parseInt(dataSnapshot.child("y").getValue().toString());
                    Player player = ticTacToe.getTurn(1);
                    ArrayChecker(player, x, y);
                }
                catch(NullPointerException e)
                {
                    e.printStackTrace();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        calculateDimensions();
    }

    private void calculateDimensions() {
        if (numColumns < 1 || numRows < 1) {
            return;
        }
        cellWidth = getWidth() / numColumns;
        cellHeight = getHeight() / numRows;
        cellChecked = new boolean[numColumns][numRows];
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        if (numColumns == 0 || numRows == 0) {
            return;
        }
        int width = getWidth();
        int height = getHeight();

        for (int i = 0; i < numColumns; i++) {
            for (int j = 0; j < numRows; j++) {
                if (cellChecked[i][j]) {
                    setCells(canvas, i, j);
                }
            }
        }

        for (int i = 1; i < numColumns; i++) {
            canvas.drawLine(i * cellWidth, 0, i * cellWidth, height, blackPaint);
        }

        for (int i = 1; i < numRows; i++) {
            canvas.drawLine(0, i * cellHeight, width, i * cellHeight, blackPaint);
        }
    }

    public void setCells(Canvas canvas, int i, int j) {

//        if(tictactoe.getPiece(j, i).getPlayer().getPnum() == 1)
//                o.setBounds(i * cellWidth, j * cellHeight,
//                        (i + 1) * cellWidth, (j + 1) * cellHeight);
//                o.draw(canvas);

        if (tictactoe.getPiece(j, i).getPlayer().getPnum() == 2)
            x.setBounds(i * cellWidth, j * cellHeight,
                    (i + 1) * cellWidth, (j + 1) * cellHeight);
        x.draw(canvas);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        player = tictactoe.getTurn(2);

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            x_place = (int) (event.getX() / cellWidth);
            y_place = (int) (event.getY() / cellHeight);

            dr.child("tictactoe").child("player2pieces").child("x").setValue(x_place);
            dr.child("tictactoe").child("player2pieces").child("y").setValue(y_place);

            //REMINDER x = column: y = row

            ArrayChecker(player, x_place, y_place);
        }

        return true;
    }

    public void ArrayChecker(Player player, int x, int y)
    {
        if (!cellChecked[x][y]) {
            tictactoe.setPiece(player, y, x);
            //tictactoe.print();
            cellChecked[x][y] = !cellChecked[x][y];
            invalidate();
            if (tictactoe.getWin()) {
                Toast.makeText(getContext(), "WINNER", Toast.LENGTH_SHORT).show();
                TicTacToeLocalActivity myActivity = (TicTacToeLocalActivity) getContext();
                myActivity.finish();

            }

            if (tictactoe.getFull()) {
                Toast.makeText(getContext(), "FULL", Toast.LENGTH_SHORT).show();
                TicTacToeLocalActivity myActivity = (TicTacToeLocalActivity) getContext();
                myActivity.finish();
            }
        } else {
            Toast.makeText(getContext(), "Has Been Selected Already", Toast.LENGTH_SHORT).show();
        }
    }

    public void setNumColumns(int numColumns)
    {
        this.numColumns = numColumns;
        calculateDimensions();
    }

    public int getNumColumns()
    {
        return numColumns;
    }

    public void setNumRows(int numRows)
    {
        this.numRows = numRows;
        calculateDimensions();
    }
    public int getNumRows()
    {
        return numRows;
    }
}
