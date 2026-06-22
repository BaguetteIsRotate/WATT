package watt;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Locater {
    public static double[] find() {
        try {
            HttpClient client = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(4))
                    .build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://ip-api.com/json/"))
                    .timeout(Duration.ofSeconds(4))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonBody = response.body();

            if (jsonBody == null || jsonBody.trim().isEmpty() || jsonBody.trim().startsWith("<")) {
                return null;
            }

            JsonElement element = JsonParser.parseString(jsonBody);
            if (!element.isJsonObject()) {
                return null;
            }

            JsonObject json = element.getAsJsonObject();
            if (json.has("status") && "success".equals(json.get("status").getAsString())) {
                double latitude = json.get("lat").getAsDouble();
                double longitude = json.get("lon").getAsDouble();
                System.out.println("Location found: Latitude = " + latitude + ", Longitude = " + longitude);
                return new double[]{latitude, longitude};
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
