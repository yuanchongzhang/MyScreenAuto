package com.zhangyu.myscreenauto;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    // 自定义类，导航布局的适配器
    private TabAdaper tabAdaper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        // 绑定对象
     /*   toolbar = (Toolbar) findViewById(R.id.toolbar);
        // 替换actionbar
        setSupportActionBar(toolbar);*/
        // 绑定viewpager与tablayout
        /*viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);*/
        // 新建适配器
        tabAdaper = new TabAdaper(getSupportFragmentManager());
        // 设置适配器
        viewPager.setAdapter(tabAdaper);

        // 直接绑定viewpager，消除了以前的需要设置监听器的繁杂工作
        tabLayout.setupWithViewPager(viewPager);

    }



    // fragment的适配器类
    class TabAdaper extends FragmentPagerAdapter {

        List<Fragment> fragmentList = new ArrayList<>();
        // 标题数组
        String[] titles = {"适配1", "适配2"};

        public TabAdaper(FragmentManager fm) {
            super(fm);
            fragmentList.add(new ListFragment());
            fragmentList.add(new RegisterFragment());

        }
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }
        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }
}
