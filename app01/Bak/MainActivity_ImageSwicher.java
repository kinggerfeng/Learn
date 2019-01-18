package pro.ooss.app01;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity_ImageSwicher extends BaseActivity {

    private ImageSwitcher is;
    private int index = 0;
    private float upX;
    private float downX;
    private int[] imgArr = new int[]{R.mipmap.img1, R.mipmap.img2, R.mipmap.img3};

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);
        is = $(R.id.is);
        is.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(MainActivity_ImageSwicher.this);
                imageView.setImageResource(imgArr[index]);
                return imageView;
            }
        });
        is.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    downX = event.getX();
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    upX = event.getX();
                    if (upX - downX > 100) {
                        index = index == 0 ? imgArr.length - 1 : index - 1;
                    } else if (downX - upX > 100) {
                        index = index == imgArr.length - 1 ? 0 : index + 1;
                    }
                    is.setImageResource(imgArr[index]);

                    return false;
                }
                return false;
            }
        });
    }




}