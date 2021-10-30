package common;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ApiConnect {
    private String from = "EUR";
    private String to = "PLN";
    private String URLapi = "https://www.amdoren.com/api/currency.php?api_key=8xRbBfxHmyu6XYGs5M4kqPTnHYNYKN&from="+ from + "&to=" + to;

    public ApiConnect() throws IOException {
        URL url = new URL(URLapi);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responsecode = conn.getResponseCode();

        if (responsecode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responsecode);
        }else {
            String inline = "";
            Scanner scanner = new Scanner(url.openStream());

            while (scanner.hasNext()) {
                inline += scanner.nextLine();
            }

            scanner.close();
            // TODO: 10/30/2021 From here 
            //Using the JSON simple library parse the string into a json object
            JSONParser parse = new JSONParser();
            JSONObject data_obj = (JSONObject) parse.parse(inline);

            //Get the required object from the above created object
            JSONObject obj = (JSONObject) data_obj.get("Global");

            //Get the required data using its key
            System.out.println(obj.get("TotalRecovered"));

            JSONArray arr = (JSONArray) data_obj.get("Countries");
        }
    }
}
