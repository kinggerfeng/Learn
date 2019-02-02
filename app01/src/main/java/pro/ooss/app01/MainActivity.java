package pro.ooss.app01;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.ViewGroup;

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