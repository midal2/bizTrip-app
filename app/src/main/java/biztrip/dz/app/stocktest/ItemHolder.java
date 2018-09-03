package biztrip.dz.app.stocktest;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ItemHolder extends RecyclerView.ViewHolder {

    public TextView tv_item_1;
    public TextView tv_item_2;
    public TextView tv_item_3;

    public ItemHolder(View itemView) {
        super(itemView);

        tv_item_1 = itemView.findViewById(R.id.tv_item_1);
        tv_item_2 = itemView.findViewById(R.id.tv_item_2);
        tv_item_3 = itemView.findViewById(R.id.tv_item_3);

    }


}
