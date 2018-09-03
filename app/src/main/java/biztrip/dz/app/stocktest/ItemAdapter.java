package biztrip.dz.app.stocktest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemHolder> {
    List<ItemInfo> itemInfoList = new ArrayList();


    public ItemAdapter(){
        createDummy();
    }

    private void createDummy() {
        Log.d("ItemHolder", "createDummy");
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.item1 = "1";
        itemInfo.item2 = "1";
        itemInfo.item3 = "1";
        itemInfoList.add(itemInfo);

        itemInfo = new ItemInfo();
        itemInfo.item1 = "2";
        itemInfo.item2 = "2";
        itemInfo.item3 = "2";
        itemInfoList.add(itemInfo);

        itemInfo = new ItemInfo();
        itemInfo.item1 = "3";
        itemInfo.item2 = "3";
        itemInfo.item3 = "3";
        itemInfoList.add(itemInfo);

    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.d("ItemHolder", "onCreateViewHolder");
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view =  inflater.inflate(R.layout.item, parent, false);

        ItemHolder itemHolder = new ItemHolder(view);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Log.d("ItemHolder", "onBindViewHolder");
        ItemInfo itemInfo = itemInfoList.get(position);

        holder.tv_item_1.setText(itemInfo.item1);
        holder.tv_item_2.setText(itemInfo.item2);
        holder.tv_item_3.setText(itemInfo.item3);

    }

    @Override
    public int getItemCount() {
        Log.d("ItemHolder", "getItemCount" + itemInfoList.size());
        return itemInfoList.size();
    }
}
