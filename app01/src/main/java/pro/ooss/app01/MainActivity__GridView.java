package pro.ooss.app01;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity__GridView extends BaseActivity {

//
    private GridView gv;
//
//    private int[] imgArr = {R.mipmap.img1, R.mipmap.img2, R.mipmap.img3, R.mipmap.img1, R.mipmap.img2, R.mipmap.img3, R.mipmap.img1, R.mipmap.img2, R.mipmap.img3};
//    private String[] txtArr = {"img1", "img2", "img3", "img1", "img2", "img3", "img1", "img2", "img3"};
//
//    private List<Map<String, Object>> datalist;
//    private SimpleAdapter simpleAdapter;
//
//    @Override
//    protected void onCreate(Bundle saveInstanceState) {
//        super.onCreate(saveInstanceState);
//        setContentView(R.layout.activity_main);
//
//        gv = $(R.id.gv);
//        datalist = new ArrayList<Map<String, Object>>();
//
//        simpleAdapter=new SimpleAdapter(this,getData(),R.layout.grid_item,new String[]{"img","txt"},new int[]{R.id.item_img,R.id.item_txt});
//
//        gv.setAdapter(simpleAdapter);
//
//
//
//    }
//
//    private List<Map<String, Object>> getData() {
//
//        for (int i =0;i<imgArr.length;i++) {
//            Log.i("ii", String.valueOf(i));
//
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("img", imgArr[i]);
//            map.put("txt", txtArr[i]);
//
//            datalist.add(map);
//        }
//
//        return datalist;
//    }
/*
  <GridView
        android:id="@+id/gv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:horizontalSpacing="5dp"
        android:numColumns="3"
        android:stretchMode="columnWidth"
        android:verticalSpacing="5dp">
    </GridView>


    <?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">


    <ImageView
        android:scaleType="centerCrop"
        android:id="@+id/item_img"
        android:layout_width="match_parent"
        android:layout_height="100dp"
        android:src="@mipmap/img1" />


    <TextView
        android:background="#fff"
        android:textAlignment="center"
        android:id="@+id/item_txt"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="我是你姐姐" />
</LinearLayout>
 */
}