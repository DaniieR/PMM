package com.example.mati.figurasaleatorias;

import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class RandomShapeView extends View{
    private Integer[] mBackgrounds = {Color.CYAN, Color.GRAY,Color.LTGRAY,Color.MAGENTA,Color.YELLOW,Color.WHITE};
    private Paint[] mForegrounds = {makePaint(Color.BLACK),makePaint(Color.BLUE),makePaint(Color.GREEN),makePaint(Color.RED)};
}
