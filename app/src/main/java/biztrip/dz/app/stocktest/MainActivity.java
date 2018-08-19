package biztrip.dz.app.stocktest;

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

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
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
        });
    }
}
