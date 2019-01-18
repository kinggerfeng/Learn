package pro.ooss.app01;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.lang.reflect.Field;

public class MainActivity01 extends AppCompatActivity {
    int statusH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setStatusBarFullTransparent();
//        setFitSystemWindow(true);
//        FrameLayout frameLayout = findViewById(R.id.container);
//        final IconView icon = new IconView(this);
//
//        icon.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                float iconW = icon.getWidth();
//                float iconH = icon.getHeight();
//                float iconX = icon.getX();
//                float iconY = icon.getY();
//                float x = event.getX();
//                float y = event.getY();
//                float duX = x - iconX;
//                float duY = y - iconY;
//
//                icon.x = (v.getLeft() + x) - iconW / 2;
//                icon.y = (v.getTop() + y) - iconH / 2;
//                icon.invalidate();
//                return false;
//            }
//        });
//        TextView text = findViewById(R.id.textView);
//        text.setText("StatusHeight: " + getStatusBarHeight());
//        frameLayout.addView(icon);
    }


    /**
     * 全透状态栏
     */
    protected void setStatusBarFullTransparent() {
        Window window = getWindow();

        if (Build.VERSION.SDK_INT >= 21) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= 19) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //虚拟键盘也透明
            //window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /**
     * 半透明状态栏
     */
    protected void setHalfTransparent() {

        if (Build.VERSION.SDK_INT >= 21) {//21表示5.0
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        } else if (Build.VERSION.SDK_INT >= 19) {//19表示4.4
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //虚拟键盘也透明
            // getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /**
     * 如果需要内容紧贴着StatusBar
     * 应该在对应的xml布局文件中，设置根布局fitsSystemWindows=true。
     */
    private View contentViewGroup;

    protected void setFitSystemWindow(boolean fitSystemWindow) {
        if (contentViewGroup == null) {
            contentViewGroup = ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
        }
        contentViewGroup.setFitsSystemWindows(fitSystemWindow);
    }

    /**
     * 为了兼容4.4的抽屉布局->透明状态栏
     */
    protected void setDrawerLayoutFitSystemWindow() {
        if (Build.VERSION.SDK_INT == 19) {
            int statusBarHeight = getStatusBarHeight();//getStatusHeight(this);
            if (contentViewGroup == null) {
                contentViewGroup = ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
            }
            if (contentViewGroup instanceof DrawerLayout) {
                DrawerLayout drawerLayout = (DrawerLayout) contentViewGroup;
                drawerLayout.setClipToPadding(true);
                drawerLayout.setFitsSystemWindows(false);
                for (int i = 0; i < drawerLayout.getChildCount(); i++) {
                    View child = drawerLayout.getChildAt(i);
                    child.setFitsSystemWindows(false);
                    child.setPadding(0, statusBarHeight, 0, 0);
                }

            }
        }
    }


    protected int getStatusBarHeight() {
        Class c = null;
        int statusBarHeight;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = this.getResources().getDimensionPixelSize(x);
            return statusBarHeight;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }


    }


}
