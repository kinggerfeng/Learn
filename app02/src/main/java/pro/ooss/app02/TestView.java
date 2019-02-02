package pro.ooss.app02;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class TestView extends View {
    public float x;
    public float y;

    public TestView(Context context) {
        super(context);
        x = 60;
        y = 10;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_launcher_background);
        canvas.drawBitmap(bitmap, x, y, paint);
//        if (bitmap!=null && bitmap.isRecycled()) {
//            bitmap.recycle();
//        }
    }
}
