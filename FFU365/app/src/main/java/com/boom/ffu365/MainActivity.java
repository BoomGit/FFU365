package com.boom.ffu365;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;

import com.boom.ffu365.adapter.HomePagerAdapter;
import com.boom.ffu365.fragment.CenterFragment;
import com.boom.ffu365.fragment.CollectionFragment;
import com.boom.ffu365.fragment.HomeFragment;
import com.boom.ffu365.fragment.MessageFragment;

import java.util.ArrayList;

import static com.boom.ffu365.R.id.rbtn2;
import static com.boom.ffu365.R.id.rbtn3;
import static com.boom.ffu365.R.id.rbtn4;

/**
 * Created by Boom on 2017/6/20.
 *  主界面的解决方案
 *  1.ViewPager+Fragment+RadioButton
 *  2.tabhost+Fragment  过时了
 *  3.ViewGroup+Fragment+动态切换  会不断的销毁和创建
 */

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private RadioButton rbtn1,rbtn2,rbtn3,rbtn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager= (ViewPager) findViewById(R.id.mViewPager);

        //LayoutInflater.from(this).inflate(R.layout.activity_main,null);
       // View.inflate(this,R.layout.activity_main,null);

        initData();
        initView();
    }

    private void initView() {

        rbtn1 = (RadioButton) findViewById(R.id.rbtn1);
        rbtn2 = (RadioButton) findViewById(R.id.rbtn2);
        rbtn3 = (RadioButton) findViewById(R.id.rbtn3);
        rbtn4 = (RadioButton) findViewById(R.id.rbtn4);
        //给下面radioButton设置点击事件
        rbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mViewPager.setCurrentItem(0,false);//false代表切换的时候不显示滑动效果
            }
        });
        rbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(1,false);
            }
        });
        rbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(2,false);
            }
        });
        rbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(3,false);
            }
        });
        //设置页面滑动的监听  为了保证滑动之后相应页面改变
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //切换到相应的页面之后调用
                switch (position){
                    case 0:
                        rbtn1.setChecked(true);
                        break;
                    case 1:
                        rbtn2.setChecked(true);
                        break;
                    case 2:
                        rbtn3.setChecked(true);
                        break;
                    case 3:
                        rbtn4.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initData() {
        //给ViewPager设置adapter
        ArrayList<Fragment> fragments = new ArrayList<>();
        //向集合fragments中添加数据
        fragments.add(new HomeFragment());
        fragments.add(new CollectionFragment());
        fragments.add(new MessageFragment());
        fragments.add(new CenterFragment());
        //getSupportFragmentManager()  是fragmentActivity里面的
        HomePagerAdapter homePagerAdapter = new HomePagerAdapter(getSupportFragmentManager(),fragments);
        mViewPager.setAdapter(homePagerAdapter);
    }
}
