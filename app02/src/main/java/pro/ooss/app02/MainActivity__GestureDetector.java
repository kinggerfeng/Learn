/*


package pro.ooss.app02;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity__GestureDetector extends AppCompatActivity implements GestureDetector.OnGestureListener {
    private Animation animation[] = new Animation[4];
    private int[] images = {
            R.mipmap.img1, R.mipmap.img2, R.mipmap.img3,
    };
    private int distance = 30;
    ViewFlipper flipper;
    GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flipper = findViewById(R.id.flipper);

        detector = new GestureDetector(MainActivity__GestureDetector.this, this);

//        for (int i = 0; i < images.length; i++) {
//            ImageView imageView = new ImageView(this);
//            imageView.setImageResource(images[i]);
//            flipper.addView(imageView);
//        }

        for (int i : images) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(i);
            flipper.addView(imageView);
        }


    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        if (e1.getX() - e2.getX() > distance) {
            flipper.showPrevious();
            return true;
        } else if (e2.getX() - e1.getX() > distance) {
            flipper.showNext();
            return true;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        return detector.onTouchEvent(event);
    }

    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        super.addContentView(view, params);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }


}

<ViewFlipper
           android:id="@+id/flipper"
           android:layout_width="match_parent"
           android:layout_height="wrap_content"></ViewFlipper>
*/