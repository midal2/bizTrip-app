package biztrip.dz.app.stocktest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

    private List<StockInfo> stockInfoList;

    public StockAdapter(){
        createDummy();
    }

    private void createDummy() {
        stockInfoList = new LinkedList<>();

        StockInfo stockInfo = new StockInfo();
        stockInfo.title    = "sample1";
        stockInfo.debi     = "sample1";
        stockInfo.dungrak  = "sample1";
        stockInfo.updatedt = "sample1";
        stockInfo.curjuka  = "sample1";
        stockInfo.lowjuka  = "sample1";
        stockInfo.highjuka = "sample1";
        stockInfoList.add(stockInfo);

        stockInfo = new StockInfo();
        stockInfo.title    = "sample2";
        stockInfo.debi     = "sample2";
        stockInfo.dungrak  = "sample2";
        stockInfo.updatedt = "sample2";
        stockInfo.curjuka  = "sample2";
        stockInfo.lowjuka  = "sample2";
        stockInfo.highjuka = "sample2";
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

        viewHolder.title.setText(stockInfo.title);
        viewHolder.debi.setText(stockInfo.debi);
        viewHolder.dungrak.setText(stockInfo.dungrak);
        viewHolder.updatedt.setText(stockInfo.updatedt);
        viewHolder.curjuka.setText(stockInfo.curjuka);
        viewHolder.lowjuka.setText(stockInfo.lowjuka);
        viewHolder.highjuka.setText(stockInfo.highjuka);

    }

    @Override
    public int getItemCount() {
        return stockInfoList.size();
    }


    static class StockInfo {
        public String title;
        public String debi;
        public String dungrak;
        public String updatedt;
        public String curjuka;
        public String lowjuka;
        public String highjuka;
    }


    class StockItemHolder extends RecyclerView.ViewHolder{
        public TextView debi;
        public TextView title;
        public TextView dungrak;
        public TextView updatedt;
        public TextView curjuka;
        public TextView lowjuka;
        public TextView highjuka;

        public StockItemHolder(@NonNull View itemView) {
            super(itemView);

            title       = itemView.findViewById(R.id.title);
            debi        = itemView.findViewById(R.id.debi);
            dungrak     = itemView.findViewById(R.id.dungrak);
            updatedt    = itemView.findViewById(R.id.updatedt);
            curjuka     = itemView.findViewById(R.id.curjuka);
            lowjuka     = itemView.findViewById(R.id.lowjuka);
            highjuka    = itemView.findViewById(R.id.highjuka);
        }
    }

}
