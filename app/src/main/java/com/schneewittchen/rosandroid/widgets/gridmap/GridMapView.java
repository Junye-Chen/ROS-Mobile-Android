package com.schneewittchen.rosandroid.widgets.gridmap;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.Nullable;

import com.schneewittchen.rosandroid.R;
import com.schneewittchen.rosandroid.utility.Utils;
import com.schneewittchen.rosandroid.widgets.base.BaseData;
import com.schneewittchen.rosandroid.widgets.base.BaseView;

/**
 * TODO: Description
 *
 * @author Nico Studt
 * @version 1.0.0
 * @created on 18.10.19
 * @updated on 27.04.20
 * @modified by Nils Rottmann
 */
public class GridMapView extends BaseView {

    public static final String TAG = "GridmapView";

    Paint paint;
    float cornerWidth;

    GridMapData data;

    public GridMapView(Context context) {
        super(context);
        init();
    }

    public GridMapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        this.cornerWidth = Utils.dpToPx(getContext(), 8);
        paint = new Paint();
        paint.setColor(getResources().getColor(R.color.whiteHigh));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
    }


    @Override
    public void onDraw(Canvas canvas) {
        Log.i(TAG, "On draw");
        float left = 0F;
        float right = 0F;
        float width = getWidth();
        float height = getHeight();
        RectF rect = new RectF(left, right, width, height);
        if (data != null) {
            canvas.drawBitmap(data.map, null, rect, paint);
            canvas.drawRoundRect(left, right, width, height, cornerWidth, cornerWidth, paint);
        } else {
            canvas.drawRoundRect(left, right, width, height, cornerWidth, cornerWidth, paint);
        }
    }

    @Override
    public void setData(BaseData data) {
        // TODO
        System.out.println("GridMapView: SetData!");
        this.data = (GridMapData) data;
        this.invalidate();
    }

}