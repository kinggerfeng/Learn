package pro.ooss.app01;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.lang.reflect.Method;

import es.dmoral.toasty.Toasty;

import static pro.ooss.mylibrary.Utils.*;


public class BaseActivity extends AppCompatActivity {
    protected final <T> T $(int id) {
        return (T) findViewById(id);
    }

    FrameLayout content;
    private static final String TAG = "BaseActivityForAuto";
    private boolean mLayoutComplete = false;
    private View mHeaderView;
    private int mHeaderViewHeight;
    View layout;
    private int navHeight = 0;
    private int[] whArr;
    int statusH=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_base);


        layout = $(R.id.layout_base);
        whArr = getWinWH();
        dealWindow();

        Log.e("ttt", "" + whArr[0] + ";" + whArr[1] + ";" + whArr[2] + ";" + whArr[3] + ";");
//        Toasty.success(this, "我是鸡肋 " + whArr[0] + ";" + whArr[1] + ";" + whArr[2] + ";" + whArr[3] + ";", Toast.LENGTH_LONG).show();
    }

    private void dealWindow() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Android 5.0 以上 全透明
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            // 状态栏（以上几行代码必须，参考setStatusBarColor|setNavigationBarColor方法源码）
            window.setStatusBarColor(Color.TRANSPARENT);

            // 虚拟导航键全透明
            window.setNavigationBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // Android 4.4 以上 半透明
            Window window = getWindow();
            // 状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 虚拟导航键
//            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }



        statusH = getStatusBarHeight(this);


        getContentResolver().registerContentObserver(Settings.System.getUriFor("navigationbar_is_min"), true, mNavigationStatusObserver);


        Boolean b=checkDeviceHasNavigationBar(this); //虚拟机（有）：但是false，小米8、荣耀7打开和关闭时：true，

        if (hasNavBar(this)) { //当隐藏虚拟按键时也会判断为true。异形屏可能错误（mi8高度：2028,2248，打开虚拟按键也是这个数值,，mi8中Toast不会依次显示，前面的会被替换？）TODO:废弃，搞来搞去还是只用style + android:fitsSystemWindows="true"，不用java设置window，使用layout_base marginTop = -statusBarHeight
            navHeight = getNavigationBarHeight(this);
            setPadding();
            Toasty.error(this, "has Nav" + " %% " + getScreenHeight(BaseActivity.this) + " ##statusH: " + statusH +" $$navH " + navHeight+"我是鸡肋 " + whArr[0] + ";" + whArr[1] + ";" + whArr[2] + ";" + whArr[3] + "; boolean: " + b,Toast.LENGTH_LONG).show();
        }


    }

    public static void setMargins(View v, int l, int t, int r, int b) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(l, t, r, b);
            v.requestLayout();
        }
    }

    private void setPadding() {
        layout.setPadding(0, 0, 0, whArr[3] - whArr[1]);
    }

    private ContentObserver mNavigationStatusObserver = new ContentObserver(new Handler()) {
        @Override
        public void onChange(boolean selfChange) {
            whArr = getWinWH();
            setPadding();

            Log.i("yyj", "selfChange = " + selfChange);
//            int navigationBarIsMin = Settings.System.getInt(getContentResolver(), "navigationbar_is_min", 0);

            Toast.makeText(BaseActivity.this, "selfChange = " + selfChange + "%%" + getNavigationBarHeight(BaseActivity.this) + "；高度：" + String.valueOf(whArr[3] - whArr[1]) + " % % " + getScreenHeight(BaseActivity.this), Toast.LENGTH_SHORT).show();
        }
    };

    //



    private int getDpi() {
        int dpi = 0;
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        @SuppressWarnings("rawtypes")
        Class c;
        try {
            c = Class.forName("android.view.Display");
            @SuppressWarnings("unchecked")
            Method method = c.getMethod("getRealMetrics", DisplayMetrics.class);
            method.invoke(display, dm);
            dpi = dm.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dpi;
    }

    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }

    public int[] getWinWH() {
        WindowManager manager = BaseActivity.this.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        int height = outMetrics.heightPixels;
//

        WindowManager windowManager =
                (WindowManager) getApplication().getSystemService(Context.
                        WINDOW_SERVICE);
        final Display display = windowManager.getDefaultDisplay();
        Point outPoint = new Point();
        if (Build.VERSION.SDK_INT >= 19) {
            display.getRealSize(outPoint);
        } else {
            display.getSize(outPoint);
        }

        int realWidth = (int) outPoint.x;
        int realHeight = (int) outPoint.y;
        //


        return new int[]{width, height, realWidth, realHeight};

    }


    //




}