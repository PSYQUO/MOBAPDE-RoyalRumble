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

import mobapde.royalrumble.R;
import mobapde.royalrumble.TicTacToeLocalActivity;

/**
 * Created by Jords on 11/12/2017.
 */

public class TTTGridView extends View
{
    private int numColumns, numRows;
    private int cellWidth, cellHeight;
    private Paint blackPaint = new Paint();
    private boolean[][] cellChecked;
    private Player player;
    private int turn;
    private TicTacToe tictactoe;

    Drawable x, o;

    public TTTGridView(Context context, TicTacToe ticTacToe)
    {
        this(context, ticTacToe, null);
    }

    public TTTGridView(Context context, TicTacToe ticTacToe, AttributeSet attrs)
    {
        super(context, attrs);
        blackPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        x = getResources().getDrawable(R.drawable.x);
        o = getResources().getDrawable(R.drawable.o);

        tictactoe = ticTacToe;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);
        calculateDimensions();
    }

    private void calculateDimensions()
    {
        if(numColumns < 1 || numRows < 1)
        {
            return;
        }
        cellWidth = getWidth() / numColumns;
        cellHeight = getHeight() / numRows;
        cellChecked = new boolean[numColumns][numRows];
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawColor(Color.WHITE);
        if(numColumns == 0 || numRows == 0)
        {
            return;
        }
        int width = getWidth();
        int height = getHeight();

        for(int i = 0; i < numColumns; i++)
        {
            for(int j = 0; j < numRows; j++)
            {
                if(cellChecked[i][j])
                {
                    setCells(canvas, i, j);
                }
            }
        }

        for(int i = 1; i < numColumns; i++)
        {
            canvas.drawLine(i * cellWidth, 0, i * cellWidth, height, blackPaint);
        }

        for(int i = 1; i < numRows; i++)
        {
            canvas.drawLine(0, i * cellHeight, width, i * cellHeight, blackPaint);
        }
    }

    public void setCells(Canvas canvas, int i, int j){

        if(tictactoe.getPiece(j, i).getPlayer().getPnum() == 1)
                o.setBounds(i * cellWidth, j * cellHeight,
                        (i + 1) * cellWidth, (j + 1) * cellHeight);
                o.draw(canvas);

        if(tictactoe.getPiece(j, i).getPlayer().getPnum() == 2)
                x.setBounds(i * cellWidth, j * cellHeight,
                        (i + 1) * cellWidth, (j + 1) * cellHeight);
                x.draw(canvas);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
            player = tictactoe.getTurn(turn);

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            int x = (int) (event.getX() / cellWidth);
            int y = (int) (event.getY() / cellHeight);

            //REMINDER x = column: y = row

            if(!cellChecked[x][y]) {
                tictactoe.setPiece(player, y,x);
                //tictactoe.print();
                cellChecked[x][y] = !cellChecked[x][y];
                invalidate();
                if(tictactoe.getWin()){
                    Toast.makeText(getContext(), "WINNER", Toast.LENGTH_SHORT).show();
                    TicTacToeLocalActivity myActivity = (TicTacToeLocalActivity) getContext();
                    myActivity.finish();

                }

                if(tictactoe.getFull()){
                    Toast.makeText(getContext(), "FULL", Toast.LENGTH_SHORT).show();
                    TicTacToeLocalActivity myActivity = (TicTacToeLocalActivity) getContext();
                    myActivity.finish();
                }
            }else{
                Toast.makeText(getContext(), "Has Been Selected Already", Toast.LENGTH_SHORT).show();
                return true;
            }

            if(turn == 1)
                turn = 2;
            else
                turn = 1;
        }

        return true;
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
