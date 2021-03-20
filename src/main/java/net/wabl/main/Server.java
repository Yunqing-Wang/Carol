package net.wabl.main;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static net.wabl.main.Settings.GSON;

public class Server {
    public static final String ADDRESS = "http://thewaveearthsociety.com:8080/api/";
    public static final String EMOJIS = "emojis/";
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String CONTENT_TYPE = "application/json";

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public static String post(String addr, Object data) {
        try {
            var json = GSON.toJson(data).replaceAll("\n", "");
            var request = HttpRequest.newBuilder()
                    .header("User-Agent", USER_AGENT)
                    .header("Content-Type", CONTENT_TYPE)
                    .uri(URI.create(ADDRESS + addr))
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            return httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (Exception e) {
            return "err";
        }
    }

    public static String patch(String addr, Object data) {
        try {
            var json = GSON.toJson(data).replaceAll("\n", "");
            var request = HttpRequest.newBuilder()
                    .header("User-Agent", USER_AGENT)
                    .header("Content-Type", CONTENT_TYPE)
                    .uri(URI.create(ADDRESS + addr))
                    .method("PATCH", HttpRequest.BodyPublishers.ofString(json))
                    .build();

            return httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (Exception e) {
            return "err";
        }
    }

    public static String delete(String addr) {
        try {
            var request = HttpRequest.newBuilder()
                    .header("User-Agent", USER_AGENT)
                    .header("Content-Type", CONTENT_TYPE)
                    .uri(URI.create(ADDRESS + addr))
                    .DELETE()
                    .build();

            return httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (Exception e) {
            return "err";
        }
    }


    public static String get(String addr, Object data) {
        try {
            var json = GSON.toJson(data).replaceAll("\n", "");
            var request = HttpRequest.newBuilder()
                    .header("User-Agent", USER_AGENT)
                    .header("Content-Type", CONTENT_TYPE)
                    .uri(URI.create(ADDRESS + addr))
                    .method("GET", HttpRequest.BodyPublishers.ofString(json))
                    .build();

            return httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (Exception e) {
            return "err";
        }
    }
}
