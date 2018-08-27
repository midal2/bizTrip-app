package biztrip.dz.app.stocktest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class StockAdapter extends RecyclerView.Adapter<StockAdapter.StockItemHolder> {

    public List<StockInfo> getStockInfoList() {
        return stockInfoList;
    }

    public void setStockInfoList(List<StockInfo> stockInfoList) {
        this.stockInfoList = stockInfoList;
    }

    //Dataset
    private List<StockInfo> stockInfoList;

    public StockAdapter(){
        createDummy();
    }

    private void createDummy() {
        stockInfoList = new LinkedList<>();
        StockInfo stockInfo = new StockInfo();
        stockInfo. col1 = "1";
        stockInfo.col2 = "2";
        stockInfo.col3 = "3";
        stockInfoList.add(stockInfo);

        stockInfo = new StockInfo();
        stockInfo.col1 = "11";
        stockInfo.col2 = "22";
        stockInfo.col3 = "33";
        stockInfoList.add(stockInfo);
    }

    @NonNull
    @Override
    public StockItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        Context context = viewGroup.getContext();

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.stock_item, viewGroup, false);

        StockItemHolder viewHolder = new StockItemHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StockItemHolder viewHolder, int i) {
        StockInfo stockInfo =  stockInfoList.get(i);

        viewHolder.col1.setText(stockInfo.col1);
        viewHolder.col2.setText(stockInfo.col2);
        viewHolder.col3.setText(stockInfo.col3);

    }

    @Override
    public int getItemCount() {
        return stockInfoList.size();
    }


    public static class StockInfo {
        public String col1;
        public String col2;
        public String col3;
    }


    class StockItemHolder extends RecyclerView.ViewHolder{
        public TextView col1;
        public TextView col2;
        public TextView col3;

        public StockItemHolder(@NonNull View itemView) {
            super(itemView);

            col1 = itemView.findViewById(R.id.tvCol1);
            col2 = itemView.findViewById(R.id.tvCol2);
            col3 = itemView.findViewById(R.id.tvCol3);
        }
    }

}

