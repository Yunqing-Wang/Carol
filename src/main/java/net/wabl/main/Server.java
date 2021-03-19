package net.wabl.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static net.wabl.main.Settings.GSON;

public class Server {
    public static final String ADDRESS = "http://thewaveearthsociety.com:8080/api/";
    public static final String EMOJIS = "emojis/";
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String CONTENT_TYPE = "application/json";

    public static String send(String type, String addr, Object data) {
        try {
            URL url = new URL(ADDRESS + addr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(type);
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Content-Type", CONTENT_TYPE);
            String json = GSON.toJson(data).replaceAll("\n", "");
            con.setRequestProperty("Content-Length", String.valueOf(json.length()));
            con.setDoOutput(true);
            con.getOutputStream().write(json.getBytes());
            int responseCode = con.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) { // success
                System.out.println("GET request did not work");
                return "Err";
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            } in.close();

            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "Err";
        }
    }

    public static String post(String addr, Object data) {
        return send("POST", addr, data);
    }

    public static String patch(String addr, Object data) {
        return send("PATCH", addr, data);
    }

    public static String get(String addr, Object json) {
        try {
            URL url = new URL(ADDRESS + addr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Content-Type", CONTENT_TYPE);
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode != HttpURLConnection.HTTP_OK) { // success
                System.out.println("GET request did not work");
                return "Err";
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();

            // print result
            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "Err";
        }
    }
}
