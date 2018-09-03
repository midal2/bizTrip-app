package biztrip.dz.app.stocktest;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private StockAdapter stockAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.view_pager);
        PagerAdapter pageAdapter = new PagerAdapter(getSupportFragmentManager());

        pageAdapter.mFragments.add(new TestList());
        pageAdapter.mTitle.add("첫번째");

        pageAdapter.mFragments.add(new WebViewFragment());
        pageAdapter.mTitle.add("두번째");

        viewPager.setAdapter(pageAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

//        viewPager.addF

    }
}
