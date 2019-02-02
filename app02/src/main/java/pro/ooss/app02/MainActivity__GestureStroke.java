/*
package pro.ooss.app02;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity__GestureStroke extends AppCompatActivity implements GestureOverlayView.OnGesturePerformedListener {

    private GestureLibrary library;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        library = GestureLibraries.fromRawResource(MainActivity__GestureStroke.this, R.raw.gestures);
        editText = findViewById(R.id.text);
        if (!library.load())
            finish();

        GestureOverlayView gestureOverlayView = findViewById(R.id.gesture);

        gestureOverlayView.setGestureColor(Color.BLACK);
        gestureOverlayView.setFadeOffset(1000);
        gestureOverlayView.addOnGesturePerformedListener(this);

    }


    @Override
    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {

        ArrayList<Prediction> gestures = library.recognize(gesture);
        int index = 0;
        double score = 0.0;
        for(int i = 0;i<gestures.size();i++){
            Prediction result= gestures.get(i);
            if(result.score>score){
                index=i;
                score=result.score;
            }
        }

        String text=editText.getText().toString();
        text+=gestures.get(index).name;
        editText.setText(text);

    }
}

<EditText
    android:id="@+id/text"
    android:background="#fff"
    android:layout_width="match_parent"
    android:layout_height="100dp" />
       <android.gesture.GestureOverlayView
           android:layout_alignParentBottom="true"
           android:id="@+id/gesture"
           android:gestureStrokeType="multiple"
           android:background="#ccc"
           android:layout_width="match_parent"
           android:layout_height="300dp"></android.gesture.GestureOverlayView>

*/