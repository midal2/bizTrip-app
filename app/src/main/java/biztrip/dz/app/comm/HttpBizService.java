package biztrip.dz.app.comm;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpBizService{

    public static Map<String, Object> send(String url, String sendStr) {
        Map<String, Object> resultMap = new HashMap();

        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setUseCaches(false);
            OutputStreamWriter os = new OutputStreamWriter(conn.getOutputStream());

            os.write(sendStr);
            os.flush();
            os.close();

            int responseCode = conn.getResponseCode();
            DataInputStream in;
            if (responseCode < HttpURLConnection.HTTP_BAD_REQUEST){
                in = new DataInputStream(conn.getInputStream());
            }else{
                in = new DataInputStream(conn.getErrorStream());
            }
            ByteArrayOutputStream bout = new ByteArrayOutputStream();

            byte[] buf = new byte[2048];

            while (true) {
                int n = in.read(buf);
                if (n == -1) break;
                bout.write(buf, 0, n);
            }
            bout.flush();
            bout.close();

            byte[] resMessage = bout.toByteArray();
            conn.disconnect();

            String temp = new String(resMessage, "utf-8");

            resultMap.put("RESPONSE_CODE", Integer.toString(responseCode));
            resultMap.put("RESPONSE_BODY", temp.trim());

        } catch (Exception e) {
            resultMap.put("RESPONSE_CODE", "9999");
            resultMap.put("RESPONSE_BODY", e.getMessage());
            e.printStackTrace();
        }

        return resultMap;
    }

}