package com.roy.demo;

        import android.graphics.Color;
        import android.os.Bundle;
        import android.support.design.widget.TabLayout;
        import android.support.v4.view.PagerAdapter;
        import android.support.v4.view.ViewPager;
        import android.support.v7.app.AppCompatActivity;
        import android.view.Gravity;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.LinearLayout;
        import android.widget.TextView;

        import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ArrayList<Integer> pages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initViews();
    }

    private void initData() {
        pages = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            pages.add(i);
        }
    }

    private void initViews() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager.setAdapter(new SimplePagerAdapter());
        tabLayout.setupWithViewPager(viewPager);
    }

    private class SimplePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return pages.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            LinearLayout ll = new LinearLayout(container.getContext());
            ll.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            ll.setGravity(Gravity.CENTER);
            TextView tv = new TextView(container.getContext());
            tv.setTextColor(Color.YELLOW);
            tv.setText("current page is=" + pages.get(position));
            ll.addView(tv);
            container.addView(ll);
            return ll;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Tab " + pages.get(position);
        }
    }
}
