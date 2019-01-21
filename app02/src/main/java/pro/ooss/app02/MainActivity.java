package pro.ooss.app02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("life","onStart");

    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("life","onPause");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("life","onDestroy");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("life","onRestart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("life","onResume");
    }



    @Override
    protected void onStop() {
        super.onStop();
        Log.i("life","onStop");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("life","onCreate");

    }
}
