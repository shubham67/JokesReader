package com.project.bittu.displayjokeslibrary;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Bittu on 7/15/2016.
 */
public class JokesListItemView extends TextView {

    private Paint marginPaint;
    private Paint linePaint;
    private int backgroundColor;
    private float leftMargin;

    public JokesListItemView(Context context) {
        super(context);
        initializeResources();
    }

    public JokesListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeResources();
    }

    public JokesListItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeResources();
    }

    private void initializeResources(){

        Resources resources = getResources();

        marginPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        marginPaint.setColor(resources.getColor(R.color.textViewMargin));
        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(resources.getColor(R.color.textViewLines));

        backgroundColor = resources.getColor(R.color.textViewBackground);
        leftMargin = resources.getDimension(R.dimen.textViewMargin);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawColor(backgroundColor);

        canvas.drawLine(0, 0, 0, getMeasuredHeight(), linePaint);
        canvas.drawLine(0, getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight(), linePaint);

        canvas.drawLine(leftMargin, 0, leftMargin, getMeasuredHeight(), marginPaint);

        canvas.save();
        canvas.translate(leftMargin, 0);

        super.onDraw(canvas);
        canvas.restore();

    }
}
