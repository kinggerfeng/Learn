package pro.ooss.app01;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;


import android.os.health.*;
import android.widget.ViewSwitcher;

import java.io.IOError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.dmoral.toasty.Toasty;
import me.zhanghai.android.materialratingbar.*;


import static pro.ooss.mylibrary.Utils.*;

public class MainActivity extends BaseActivity {

    private int[] imgArr = {R.mipmap.img1, R.mipmap.img2, R.mipmap.img3, R.mipmap.img1, R.mipmap.img2, R.mipmap.img3, R.mipmap.img1, R.mipmap.img2, R.mipmap.img3};

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        ViewGroup layout_base = $(R.id.layout_base);
        LayoutInflater.from(this).inflate(R.layout.activity_main, layout_base, true);
//        setContentView(R.layout.activity_main);
//
//        Spinner sp = $(R.id.sp);
//
//        String[] spArr = {"吴小霞", "冯学林"};
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spArr);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        sp.setAdapter(adapter);

//        View root = LayoutInflater.from(this).inflate(R.layout.activity_main, null);


//        int navHeight = getNavigationBarHeight(this);
//        View root = $(R.id.layout_wrap);
//        root.setPadding(0, 0, 0, navHeight);
//        Toasty.info(this, "我是鸡肋 " + navHeight).show();

    }


}