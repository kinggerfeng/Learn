/*
package pro.ooss.app02;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button done = findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ((EditText) findViewById(R.id.name)).getText().toString();
                String pwd = ((EditText) findViewById(R.id.pwd)).getText().toString();
                Intent intent = getIntent();

                intent.putExtra("name", name);
                intent.putExtra("pwd", pwd);
                setResult(1, intent);
                finish();
            }
        });


    }


}
*/

/*

package pro.ooss.app02;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private final static int REQUESTCODE = 0x002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("life", "onCreate");
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                startActivityForResult(intent, REQUESTCODE);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {


        if (resultCode == 1 && requestCode == REQUESTCODE && data != null) {

//            String str= data.getStringExtra("name");
//            Log.e("eeeee",  str);


//            Bundle b = data.getExtras();
//            if (b == null)
//                return;

Bundle b= data.getExtras();
            Log.e("eeeee",  b.getString("name"));
            ((TextView) findViewById(R.id.name)).setText(data.getStringExtra("name"));
            ((TextView) findViewById(R.id.pwd)).setText(data.getStringExtra("pwd"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("life", "onStart");


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("life", "onPause");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("life", "onDestroy");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("life", "onRestart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("life", "onResume");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i("life", "onStop");

    }


}


 */
