package biztrip.dz.app.stocktest;

import android.graphics.pdf.PdfDocument;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private StockAdapter stockAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.view_pager);
        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager());

        final MyFragment myFragment = new MyFragment();
        pageAdapter.addFragement(myFragment, "첫번째");
        pageAdapter.addFragement(new MyFragment(), "두번째");
        pageAdapter.addFragement(new MyFragment(), "세번째");
        pageAdapter.addFragement(new MyFragment(), "네번째");
        viewPager.setAdapter(pageAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        FloatingActionButton fab = findViewById(R.id.fab_refresh);
        fab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Log.d("Button", "테스트ssss!!!!!");
                AsyncStockDataGather asyncStockDataGather =
                        new AsyncStockDataGather(getResources().getString(R.string.stock_server_url),
                                getResources().getString(R.string.stock_svc_info));

                asyncStockDataGather.execute(myFragment.getStockAdapter());
                Log.d("Button", "테스트eee!!!!!");


            }
        });


        /*RecyclerView recyclerView = findViewById(R.id.recyclerView);
        stockAdapter = new StockAdapter();

        recyclerView.setAdapter(stockAdapter);

        Button button =  findViewById(R.id.button);
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeDataSet();
            }

            private void changeDataSet() {
                List<StockAdapter.StockInfo> stockInfoList = new LinkedList<>();
                StockAdapter.StockInfo stockInfo = new StockAdapter.StockInfo();
                stockInfo.col1 = "t1";
                stockInfo.col2 = "t2";
                stockInfo.col3 = "t3";
                stockInfoList.add(stockInfo);

                stockInfo = new StockAdapter.StockInfo();
                stockInfo.col1 = "t4";
                stockInfo.col2 = "t5";
                stockInfo.col3 = "t6";
                stockInfoList.add(stockInfo);

                stockAdapter.setStockInfoList(stockInfoList);
                stockAdapter.notifyDataSetChanged();
            }
        });*/
    }
}
