package biztrip.dz.app.stocktest;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import biztrip.dz.app.comm.HttpBizService;
import static biztrip.dz.app.comm.Comm.n2v;

public class AsyncStockDataGather extends AsyncTask<StockAdapter, List<StockAdapter.StockInfo>, Void> {

    private String url;
    private String svc;
    private StockAdapter[] stockAdapters;


    public AsyncStockDataGather(String url, String svc) {
        super();
        this.url = url;
        this.svc = svc;
    }

    @Override
    protected void onProgressUpdate(List<StockAdapter.StockInfo>... lists) {
        super.onProgressUpdate(lists);

        stockAdapters[0].setStockInfoList(lists[0]);
        stockAdapters[0].notifyDataSetChanged();

    }

    @Override
    protected Void doInBackground(StockAdapter... stockAdapters) {
        Map<String, Object> map = HttpBizService.send(url + svc, "");
        Log.d("doInBack", map.toString());

        if ("200".equals(n2v(map.get("RESPONSE_CODE")))){
            String strJson = n2v(map.get("RESPONSE_BODY"));

            try {
                JSONArray jsonArray = new JSONArray(strJson);
                List<StockAdapter.StockInfo> stockInfos = new LinkedList<>();
                for(int i=0; i < jsonArray.length(); i++){
                    JSONObject json = jsonArray.getJSONObject(i);
                    stockInfos.add(toStockInfo(json));
                }

                this.stockAdapters = stockAdapters;
                publishProgress(stockInfos);

                //stockAdapters[0].setStockInfoList(stockInfos);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        };

        return null;
    }

    private StockAdapter.StockInfo toStockInfo(JSONObject json) {
        StockAdapter.StockInfo stockInfo = new StockAdapter.StockInfo();

        try {
            stockInfo.title = n2v(json.get("jongName"))
                    + "[" + n2v(json.get("stockCd")) + "]";
            stockInfo.curjuka = n2v(json.get("curJuka"));
            stockInfo.debi = n2v(json.get("debi"));
            stockInfo.dungrak = n2v(json.get("dungRak"));
            stockInfo.highjuka = n2v(json.get("highJuka"));
            stockInfo.lowjuka = n2v(json.get("lowJuka"));
            stockInfo.updatedt = n2v(json.get("updateDt"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return stockInfo;
    }
}
