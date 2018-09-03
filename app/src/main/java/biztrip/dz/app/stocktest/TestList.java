package biztrip.dz.app.stocktest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TestList extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.d("TestList", "onCreateView");
        View view = inflater.inflate(R.layout.test_list, null);

        RecyclerView recyclerView = view.findViewById(R.id.recyler_view);
        ItemAdapter itemAdapter = new ItemAdapter();

        Log.d("TestList", "recyclerView:" + recyclerView);

        recyclerView.setAdapter(itemAdapter);

        return view;
    }
}
