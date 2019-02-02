package pro.ooss.mylibrary.views;


import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;

import androidx.appcompat.widget.AppCompatButton;
import pro.ooss.mylibrary.R;

/**
 * usage 1:
 * <pro.ooss.mylibrary.views.RoundButton
 * style="@style/RoundButton"
 * android:layout_marginTop="16dp"
 * android:text="RoundBtn"
 * app:btnPressedRatio="0.8"
 * app:btnCornerRadius="30dp"
 * app:btnSolidColor="#3F51B5" />
 * usage 2:
 * <pro.ooss.mylibrary.views.RoundButton
 * style="@style/RoundButton"
 * android:layout_marginTop="16dp"
 * android:text="RoundBtn"
 * app:btnCornerRadius="30dp"
 * app:btnStrokeWidth="2dp"
 * app:btnStrokeColor="#500"
 * app:btnSolidColor="#66ff0000" />
 * <p>
 * style:
 * <style name="RoundButton">
 * <item name="android:layout_width">match_parent</item>
 * <item name="android:layout_height">40dp</item>
 * <item name="android:layout_weight">1</item>
 * <item name="android:layout_gravity">center</item>
 * <item name="android:gravity">center</item>
 * <item name="android:textColor">#ccffffff</item>
 * <item name="android:clickable">true</item>
 * <item name="android:enabled">true</item>
 * <item name="btnPressedRatio">0.9</item>
 * </style>
 * <p>
 * attrs:
 * <declare-styleable name="RoundButton">
 * <!-- 背景色 -->
 * <attr name="btnSolidColor" format="color" />
 * <!-- 边框色 -->
 * <attr name="btnStrokeColor" format="color" />
 * <!--是否使用禁用颜色-->
 * <attr name="btnDisabledState" format="boolean" />
 * <!-- 边框厚度 -->
 * <attr name="btnStrokeWidth" format="dimension" />
 * <!-- 边框虚线长度 -->
 * <attr name="btnStrokeDashWidth" format="dimension" />
 * <!-- 边框虚线间隙 -->
 * <attr name="btnStrokeDashGap" format="dimension" />
 * <!-- 圆角半径，stadium 表示半径为 min(height,width) / 2-->
 * <attr name="btnCornerRadius" format="dimension">
 * <enum name="stadium" value="-1" />
 * </attr>
 * <!-- 自动计算按下(pressed)状态颜色的系数, 值为0时不自动计算 -->
 * <attr name="btnPressedRatio" format="float" />
 * </declare-styleable>
 */
public final class RoundButton extends AppCompatButton {
    boolean disabledState;
    TypedArray a;
    float pressedRatio;
    int cornerRadius;
    int strokeColor;
    int strokeWidth;
    int strokeDashWidth;
    int strokeDashGap;

    public RoundButton(Context context) {
        this(context, null);
    }

    public RoundButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);


        a = context.obtainStyledAttributes(attrs, R.styleable.RoundButton);

        pressedRatio = a.getFloat(R.styleable.RoundButton_btnPressedRatio, 0.80f);
        cornerRadius = a.getLayoutDimension(R.styleable.RoundButton_btnCornerRadius, 0);

        ColorStateList solidColor = a.getColorStateList(R.styleable.RoundButton_btnSolidColor);
        disabledState = a.getBoolean(R.styleable.RoundButton_btnDisabledState, false);
        strokeColor = a.getColor(R.styleable.RoundButton_btnStrokeColor, 0x0);
        strokeWidth = a.getDimensionPixelSize(R.styleable.RoundButton_btnStrokeWidth, 0);
        strokeDashWidth = a.getDimensionPixelSize(R.styleable.RoundButton_btnStrokeDashWidth, 0);
        strokeDashGap = a.getDimensionPixelSize(R.styleable.RoundButton_btnStrokeDashGap, 0);

        a.recycle();

        setSingleLine(true);
        setGravity(Gravity.CENTER);

        RoundDrawable rd = new RoundDrawable(cornerRadius == -1);
        rd.setCornerRadius(cornerRadius == -1 ? 0 : cornerRadius);
        rd.setStroke(strokeWidth, strokeColor, strokeDashWidth, strokeDashGap);

        if (solidColor == null) {
            solidColor = ColorStateList.valueOf(0);
        }
        if (solidColor.isStateful()) {
            rd.setSolidColors(solidColor);
        } else if (pressedRatio > 0.0001f) {
            rd.setSolidColors(csl(solidColor.getDefaultColor(), pressedRatio));
        } else {

            rd.setColor(solidColor.getDefaultColor());
        }
        if (Build.VERSION.SDK_INT > 16)
            setBackground(rd);
        else
            setBackgroundDrawable(rd);
    }

    // 灰度
//    int greyer(int color) {
//        int blue = (color & 0x000000FF) >> 0;
//        int green = (color & 0x0000FF00) >> 8;
//        int red = (color & 0x00FF0000) >> 16;
//        int grey = Math.round(red * 0.299f + green * 0.587f + blue * 0.114f);
////        return Color.argb(0xff, grey, grey, grey);
//        return Color.argb(0xff, Math.round(red * 2.0f), Math.round(green * 2.0f), Math.round(blue * 2.0f));
//    }
    int greyer(int color) {
        if (!disabledState)
            return color;
        color = (color >> 24) == 0 ? 0x22808080 : color;
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[1] *= 0.4;
        return Color.HSVToColor(color >> 24, hsv);

    }

    // 明度
    int darker(int color, float ratio) {
        color = (color >> 24) == 0 ? 0x22808080 : color;
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[2] *= ratio;
        return Color.HSVToColor(color >> 24, hsv);
    }

    ColorStateList csl(int normal, float ratio) {
        int disabled = greyer(normal);
        int pressed = darker(normal, ratio);
        int[][] states = new int[][]{{android.R.attr.state_pressed}, {android.R.attr.state_enabled}, {}};
        int[] colors = new int[]{pressed, normal, disabled};
        return new ColorStateList(states, colors);
    }

    private static class RoundDrawable extends GradientDrawable {
        private boolean mIsStadium = false;

        private ColorStateList mSolidColors;
        private int mFillColor;

        private RoundDrawable(boolean isStadium) {
            mIsStadium = isStadium;
        }

        private void setSolidColors(ColorStateList colors) {
            mSolidColors = colors;
            setColor(colors.getDefaultColor());
        }

        @Override
        protected void onBoundsChange(Rect bounds) {
            super.onBoundsChange(bounds);
            if (mIsStadium) {
                RectF rect = new RectF(getBounds());
                setCornerRadius((rect.height() > rect.width() ? rect.width() : rect.height()) / 2);
            }
        }

        @Override
        public void setColor(int argb) {
            mFillColor = argb;
            super.setColor(argb);
        }

        @Override
        protected boolean onStateChange(int[] stateSet) {
            if (mSolidColors != null) {
                final int newColor = mSolidColors.getColorForState(stateSet, 0);
                if (mFillColor != newColor) {
                    setColor(newColor);
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean isStateful() {
            return super.isStateful() || (mSolidColors != null && mSolidColors.isStateful());
        }
    }
}

