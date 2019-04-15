package searchDealerLogic;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

public class DealerDistance {
    public static String getDistance(String origin, String destination) throws IOException {
        String url = "http://168.61.16.148:8888";
        String charset = "UTF-8";
        String param1 = origin;
        String param2 = destination;
        String result = "";
        String query = String.format("param1=%s&param2=%s",
                URLEncoder.encode(param1, charset),
                URLEncoder.encode(param2, charset));


        URLConnection connection = new URL(url + "/" + param1 +"/"+ param2).openConnection();
        connection.setRequestProperty("Accept-Charset", charset);
        try {
            InputStream response = connection.getInputStream();

            Scanner s = new Scanner(response).useDelimiter("\\A");
            result = s.hasNext() ? s.next() : "";


        } catch (IOException e) {
            e.printStackTrace();
        }


        return result;
    }
}
