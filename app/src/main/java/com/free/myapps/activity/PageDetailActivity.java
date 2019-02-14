package com.free.myapps.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.free.myapps.R;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.free.myapps.adapter.SlidingImage_Adapter;
import com.free.myapps.utils.ImageModel;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
public class PageDetailActivity extends AppCompatActivity {

    private static ViewPager mPager;
    private static int currentPage = 0, NUM_PAGES = 0, index=0;
    private ArrayList<ImageModel> imageModelArrayList;

    private int[] myImageList0 = new int[]{R.drawable.agumon, R.drawable.greymon,
            R.drawable.metalgreymon};

    private int[] myImageList1 = new int[]{R.drawable.gabumon, R.drawable.garurumon,
            R.drawable.weregarurumon};

    private int[] myImageList2 = new int[]{R.drawable.tentomon, R.drawable.kabuterimon,
            R.drawable.megakabuterimon};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_detail);
        index=getIntent().getIntExtra("index",0);
        imageModelArrayList = new ArrayList<>();
        imageModelArrayList = populateList();

        init();

    }

    private ArrayList<ImageModel> populateList(){

        ArrayList<ImageModel> list = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            ImageModel imageModel = new ImageModel();
            switch (index) {
                case 0:
                    imageModel.setImage_drawable(myImageList0[i]);
                    break;

                case 1:
                    imageModel.setImage_drawable(myImageList1[i]);
                    break;

                case 2:
                    imageModel.setImage_drawable(myImageList2[i]);
                    break;

                default:
                    break;
            }


            list.add(imageModel);
        }

        return list;
    }

    private void init() {

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new SlidingImage_Adapter(PageDetailActivity.this,imageModelArrayList));

        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

//Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES =imageModelArrayList.size();

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }

    @Override
    public void onBackPressed() {finish();}
}
