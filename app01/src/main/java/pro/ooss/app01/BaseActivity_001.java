package pro.ooss.app01;

import android.content.Context;
import android.database.ContentObserver;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

import static pro.ooss.mylibrary.Utils.getNavigationBarHeight;
import static pro.ooss.mylibrary.Utils.getStatusBarHeight;


public class BaseActivity_001 extends AppCompatActivity {
    protected final <T> T $(int id) {
        return (T) findViewById(id);
    }

    FrameLayout content;
    private static final String TAG = "BaseActivityForAuto";
    private boolean mLayoutComplete = false;
    private View mHeaderView;
    private int mHeaderViewHeight;
    View layout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        layout = $(R.id.layout_wrap);

        getContentResolver().registerContentObserver(Settings.System.getUriFor("navigationbar_is_min"), true, mNavigationStatusObserver);

        int navHeight = getNavigationBarHeight(this);
//        View root = $(R.id.drawer_layout);

        layout.setPadding(0, 0, 0, navHeight);
        Toasty.info(this, "我是鸡肋 " + navHeight +"statusBar: " + getStatusBarHeight(this)).show();
    }

    private ContentObserver mNavigationStatusObserver = new ContentObserver(new Handler()) {
        @Override
        public void onChange(boolean selfChange) {
            //TODO: deal with data change
            int h;
            View view = getLayoutInflater().inflate(R.layout.activity_main, null);
            LinearLayout linearlayout = (LinearLayout) view.findViewById(R.id.layout_wrap);
//measure方法的参数值都设为0即可
            linearlayout.measure(0, 0);
//获取组件宽度
            int width = linearlayout.getMeasuredWidth();
//获取组件高度
            int height = linearlayout.getMeasuredHeight();
            Toast.makeText(BaseActivity_001.this, "selfChange = " + selfChange + "%%" + getNavigationBarHeight(BaseActivity_001.this) + "；高度：" + getWinWH(), Toast.LENGTH_SHORT).show();
            Log.i("yyj", "selfChange = " + selfChange);

            int navigationBarIsMin = Settings.System.getInt(getContentResolver(), "navigationbar_is_min", 0);
        }
    };

//

    public  String getWinWH() {

        WindowManager manager = this.getWindowManager();
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
        int mRealSizeWidth;//手机屏幕真实宽度
        int mRealSizeHeight;//手机屏幕真实高度
        mRealSizeHeight = outPoint.y;
        mRealSizeWidth = outPoint.x;
        //


        return "虚拟高度：" + height + "；真实高度：" + mRealSizeHeight;

    }


    //



}