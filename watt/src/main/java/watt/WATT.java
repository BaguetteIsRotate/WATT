package watt;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.net.URI;
import java.net.http.*;
import java.time.ZonedDateTime;
import java.awt.*;
import com.google.gson.*;
import java.time.*;
public class WATT{
    public static void main(String[] args) throws Exception{
        //Make WATT window
        JFrame watt = new JFrame("Weather App of Terror and Trauma");
        watt.setLayout(new BorderLayout());
        watt.setSize(910,580);
        watt.setLocationRelativeTo(null);
        watt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
        //add the Box of Happiness
        BoxOfHappiness box = new BoxOfHappiness();
        JPanel left= new JPanel(new BorderLayout());
        JPanel topLeft= new JPanel(new BorderLayout());
        JLabel text = new JLabel("Box of Happiness");
        text.setHorizontalAlignment(JLabel.CENTER); 
        String thing = box.generate(0,3);
        JLabel label= new JLabel(thing);
        label.setHorizontalAlignment(JLabel.CENTER); 
        topLeft.add(text,BorderLayout.NORTH);
        topLeft.add(label,BorderLayout.SOUTH);
        topLeft.setSize(200,200);
        topLeft.setBorder(new LineBorder(Color.BLACK, 1, true));
        topLeft.setOpaque(true); 
        topLeft.setBackground(Color.CYAN); 
        left.add(topLeft, BorderLayout.NORTH);
        
        //Add forecast
        ZonedDateTime dateandtime = ZonedDateTime.now();

        JLabel now = new JLabel("Today is "+dateandtime+", and the weather is currently "+getCurrentWeather(0,0)+".");
        
        JPanel right = new JPanel();
        right.add(now, BorderLayout.NORTH);

        watt.add(right,BorderLayout.EAST);
        watt.add(left,BorderLayout.WEST);
        watt.setVisible(true);
    } 
    public static int[] getForecast(double latitude, double longitude) throws Exception{
        String url = "https://api.open-meteo.com/v1/forecast" + "?latitude=" + latitude + "&longitude=" + longitude + "&daily=weather_code";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JsonObject root = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject current = root.getAsJsonObject("daily");
        JsonElement jsonStr = current.get("weather_code");
        JsonArray array = jsonStr.getAsJsonArray();
        int[] code = new int[array.size()];
        for(int i=0; i<array.size(); i++){
            code[i]=array.get(i).getAsInt();
        }
        return code;
    }
    public static int getCurrentWeather(double latitude, double longitude) throws Exception{
        String url = "https://api.open-meteo.com/v1/forecast" + "?latitude=" + latitude + "&longitude=" + longitude + "&current=weather_code";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JsonObject root = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject current = root.getAsJsonObject("current");
        int code = current.get("weather_code").getAsInt();  
        return code;
    }
}