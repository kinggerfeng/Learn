package pro.ooss.app01;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import androidx.appcompat.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;


public class MainActivity_001 extends AppCompatActivity implements OnCheckedChangeListener {
    protected final <T> T $(int id) {
        return (T) findViewById(id);
    }


    private EditText et;
    private CheckBox cb;
    private Chronometer ch;
    private ProgressBar pb;
    private Handler mHandel;
    private int pbStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup rg = $(R.id.rg);
        RadioGroup rg1 = $(R.id.rg1);
        final RadioButton rg11 = $(R.id.rg11);
        ImageView img = findViewById(R.id.img);
        rg.setOnCheckedChangeListener(this);
        rg1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Toast.makeText(MainActivity_001.this, checkedId + " clickeded , " + rg11.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        et = $(R.id.pwd);
        cb = $(R.id.show_pwd);

//        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (cb.isChecked()) {
//                    et.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
//                }else{
//                    et.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
//                }
//            }
//        });
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb.isChecked()) {
                    et.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    et.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
//        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (cb.isChecked()) {
//                    et.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
//                }else{
//                    et.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
//                }
//            }
//        });

        ch = $(R.id.ch);
        ch.setBase(SystemClock.elapsedRealtime());
        ch.start();
        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (SystemClock.elapsedRealtime() - ch.getBase() >= 10 * 1000)
                    ch.stop();
            }
        });
        pb = $(R.id.pb);
        mHandel = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what == 0x111) {
                    pb.setProgress(pbStatus);
                } else {
                    Toasty.success(MainActivity_001.this, "进度完成").show();
                    pb.setVisibility(View.GONE);
                }
                return false;
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    pbStatus = doWork();
                    Message m = new Message();
                    if (pbStatus < 200) {
                        m.what = 0x111;
                        mHandel.sendMessage(m);
                    } else {
                        m.what = 0x110;
                        mHandel.sendMessage(m);
                        break;

                    }
                }

            }

            private int doWork() {
                pbStatus += Math.random() * 10;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return (int) pbStatus;
            }
        }).start();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        RadioButton rb = findViewById(checkedId);
        Toast.makeText(this, checkedId + " clickeded , " + rb.getText(), Toast.LENGTH_SHORT).show();

//        Toasty.error(getApplicationContext(),"WuXiaoXia, I love you very much,do you know? I think no!").show();
        Toasty.Config.getInstance().setErrorColor(getResources().getColor(R.color.tran01)).apply();
        Toasty.error(getApplicationContext(), R.string.app_name).show();
        Log.e("ee", "我爱你");
    }


}