package belal.brur.com.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import belal.brur.com.R;
import belal.brur.com.adapter.AdapterFullScreenImage;
import belal.brur.com.utils.Tools;

import static belal.brur.com.utils.CommonContents.COMMON_IMAGE_PATH;


public class ActivityFullScreenImage extends AppCompatActivity {

    private AdapterFullScreenImage adapter;
    private ViewPager viewPager;
    private TextView text_page;
    String image="";
    int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_full_screen_image);

        initUI();

    }

    private void initUI() {
        viewPager = (ViewPager) findViewById(R.id.pager);
        text_page = (TextView) findViewById(R.id.text_page);

        ArrayList<String> items = new ArrayList<>();

        if (getIntent() != null) {
            image = getIntent().getExtras().getString(COMMON_IMAGE_PATH);
        }
        Log.e("image", image + "");

        items.add( image );

        adapter = new AdapterFullScreenImage(ActivityFullScreenImage.this, items);
        final int total = adapter.getCount();
        viewPager.setAdapter(adapter);

        text_page.setText( String.format(getString(R.string.image_of), (position + 1), total));

        // displaying selected image first
        viewPager.setCurrentItem(position);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int pos, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int pos) {
                text_page.setText( String.format(getString( R.string.image_of), (pos + 1), total));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        ((ImageButton) findViewById(R.id.btnClose)).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // for system bar in lollipop
        Tools.systemBarLolipop(this);
    }


}

