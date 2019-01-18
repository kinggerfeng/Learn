package pro.ooss.mylibrary;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import static pro.ooss.mylibrary.Utils.getNavigationBarHeight;

public class LayoutBase extends RelativeLayout {

    private int navHeight;
    private String toaStr = "";

    private String TAG = "gggggg";

    public LayoutBase(Context context, AttributeSet attrs) {
        super(context, attrs);

        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.layout_base, this);


        navHeight = getNavigationBarHeight(context);
        View layout = findViewById(R.id.layout_base);
        layout.setPadding(0,0,0,200);
        toaStr += "navH: " + navHeight;


        View childView = ((ViewGroup) findViewById(android.R.id.content));//.getChildAt(0);
        Log.e("eee", String.valueOf(childView));


        Toa(context);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        Log.e(TAG, "onMeasure--widthMode-->" + widthMode);
        switch (widthMode) {
            case MeasureSpec.EXACTLY:

                break;
            case MeasureSpec.AT_MOST:

                break;
            case MeasureSpec.UNSPECIFIED:

                break;
        }
        Log.e(TAG, "onMeasure--widthSize-->" + widthSize);
        Log.e(TAG, "onMeasure--heightMode-->" + heightMode);
        Log.e(TAG, "onMeasure--heightSize-->" + heightSize);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.e(TAG, "onLayout");


        View layout = findViewById(R.id.layout_base);
        toaStr += "navH: " + navHeight;


        layout.setPadding(0, 0, 0, navHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int with = getWidth();
        int height = getHeight();
        Log.e(TAG, "onDraw---->" + with + "*" + height);

    }

    private void Toa(Context context) {
        Toast.makeText(context, toaStr, Toast.LENGTH_SHORT).show();
    }


}
