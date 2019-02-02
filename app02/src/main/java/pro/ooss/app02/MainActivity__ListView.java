package pro.ooss.app02;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity__ListView extends AppCompatActivity {
    /*
    private ListView lv;
    private int[] imgArr = {R.mipmap.img1, R.mipmap.img2, R.mipmap.img3};
    private String[] txtArr = {"wuxiaoxia", "wudaxia", "dawuxia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < imgArr.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("img", imgArr[i]);
            map.put("txt", txtArr[i]);
            list.add(map);
        }

        lv = findViewById(R.id.lv);

        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.list_img, new String[]{"img", "txt"}, new int[]{R.id.img, R.id.txt});
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Map<String, Object> map = (Map<String, Object>) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity__ListView.this, String.valueOf(map.get("txt")) + id, Toast.LENGTH_SHORT).show();
            }
        });
    }


    <?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:orientation="horizontal"
    android:padding="16dp"
    android:descendantFocusability="blocksDescendants"
    android:layout_height="wrap_content">




    <ImageView
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toLeftOf="@+id/txt"
        android:id="@+id/img"
        android:contentDescription="img"
        android:layout_width="80dp"
        android:layout_height="80dp"
        android:src="@mipmap/img1"
        android:scaleType="centerCrop"/>


    <TextView
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintLeft_toRightOf="@id/img"
        app:layout_constraintRight_toLeftOf="@+id/btn"
        android:id="@+id/txt"
        android:layout_width="0dp"
        android:layout_height="80dp"
        android:paddingLeft="10dp"
        android:paddingRight="10dp"
        android:textSize="20sp"
        android:maxLines="2"
        android:ellipsize="end"
        android:gravity="center_vertical"
        android:text="玩儿玩儿翁我认为二玩儿翁玩儿翁提味儿我玩儿翁玩儿翁二玩儿翁"/>

    <Button
        android:clickable="false"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintLeft_toRightOf="@id/txt"
        app:layout_constraintRight_toRightOf="parent"
        android:id="@+id/btn"
        android:background="#ccc"
        android:gravity="center"
        android:height="80dp"
        android:layout_width="80dp"
        android:layout_height="wrap_content"
        android:text="霞"/>

        <ListView
        android:id="@+id/lv"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:overScrollMode="never">

    </ListView>
    */
}
