package pro.ooss.app02;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.content.SearchRecentSuggestionsProvider;
import android.content.res.Resources;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private GridView gv;
    private TextView tv;

    private String[] names = {"我爱你01", "我爱你02", "我爱你03"};
    private String[] indexs = {"我爱你ind01", "我爱你ind02", "我爱你ind03", "我爱你ind04", "我爱你ind05", "我爱你ind06"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gv = findViewById(R.id.gv);
        tv = findViewById(R.id.tv);
        tv.setText("New Text");
        tv.setBackgroundColor(getResources().getColor(R.color.bg));
        List<Map<String, Object>> list = new ArrayList<>();

//        for (int i = 0; i < names.length; i++) {
//            Map<String, Object> map = new HashMap<String, Object>();
//
//            map.put("name", names[i]);
//            list.add(map);
//        }
        String[] wxx = getResources().getStringArray(R.array.ctype);
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", names[i]);
            map.put("index", indexs[i]);
            list.add(map);

        }


        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.grids, new String[]{"name","index"}, new int[]{R.id.name,R.id.index});

        gv.setAdapter(adapter);


    }


}
