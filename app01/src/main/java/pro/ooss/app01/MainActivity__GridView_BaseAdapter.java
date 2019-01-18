package pro.ooss.app01;

public class MainActivity__GridView_BaseAdapter extends BaseActivity {

//    private int[] imgArr = {R.mipmap.img1, R.mipmap.img2, R.mipmap.img3, R.mipmap.img1, R.mipmap.img2, R.mipmap.img3, R.mipmap.img1, R.mipmap.img2, R.mipmap.img3};
//
//    @Override
//    protected void onCreate(Bundle saveInstanceState) {
//        super.onCreate(saveInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        GridView gv = $(R.id.gv);
//
//        gv.setAdapter(new ImageAdapter(this));
//
//    }
//
//    public class ImageAdapter extends BaseAdapter {
//
//
//        private Context context;
//
//        ImageAdapter(Context c) {
//            Log.e("con","0000000000000000000000");
//            context = c;
//
//        }
//
//        @Override
//        public int getCount() {
//            return imgArr.length;
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            ImageView imageView;
//            Log.e("con","11111111111111111");
//            if (convertView == null) {
//                Log.e("con","122222222");
//                imageView = new ImageView(context);
//                imageView.setLayoutParams(new GridView.LayoutParams(100, 90));
//                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            } else {
//                Log.e("con","3333333333333333333333");
//                imageView = (ImageView) convertView;
//            }
//            imageView.setImageResource(imgArr[position]);
//            return imageView;
//        }
//    }

//<GridView
//    android:layout_width="match_parent"
//    android:layout_height="match_parent"
//    android:id="@+id/gv"
//    android:verticalSpacing="5dp"
//    android:columnWidth="100dp"
//    android:stretchMode="columnWidth"
//    android:numColumns="auto_fit"
//    android:gravity="center"></GridView>

}