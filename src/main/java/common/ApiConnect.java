package common;

import model.Currency;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApiConnect {
    private static String base_currency = "USD";
    private static String URLapi = "https://freecurrencyapi.net/api/v2/latest?apikey=8569b880-39af-11ec-b510-31e1cbd4f707&base_currency=";

    public static Currency makeRequest(String from, String to) throws IOException, ParseException {
        URL url = new URL(URLapi + from);
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

            JSONParser parse = new JSONParser();
            JSONObject data_obj = (JSONObject) parse.parse(inline);

            JSONObject data = (JSONObject) data_obj.get("data");
            double target = (double) data.get(to);

            return new Currency(to, target);
        }
    }

    public static List<Currency> makeRequestAll(String from) throws IOException, ParseException {
        URL url = new URL(URLapi + from);
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

            JSONParser parse = new JSONParser();
            JSONObject data_obj = (JSONObject) parse.parse(inline);

            JSONObject jsonObject = (JSONObject) data_obj.get("data");
            // TODO: 10/31/2021 make json array  

            return null;
        }
    }

}
