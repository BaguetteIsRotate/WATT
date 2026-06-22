package watt;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.net.URI;
import java.net.http.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.google.gson.*;
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
        topLeft.setBorder(new LineBorder(Color.BLACK, 1, true));
        topLeft.setOpaque(true); 
        topLeft.setBackground(Color.CYAN); 
        left.add(topLeft, BorderLayout.NORTH);
        
        //Add forecast
        watt.add(left,BorderLayout.WEST);
        JPanel right = new JPanel();
        double[] coordinates = getLocation();
        int[] jeremy = getForecast(coordinates[0], coordinates[1]);

        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> forecast = new JList<>(model);
        for(int i=0; i<jeremy.length; i++){
            model.addElement(codetoweather(jeremy[i]));
        }
        right.add(forecast,BorderLayout.SOUTH);
        watt.add(right,BorderLayout.EAST);
        JButton refresh_button = new JButton("refresh");
        ZonedDateTime dateandtime = ZonedDateTime.now();

        JLabel now = new JLabel("Today is "+dateandtime.format(DateTimeFormatter.ofPattern("M/d/uuuu"))+", and we currently have "+codetoweather(getCurrentWeather(coordinates[0], coordinates[1]))+".");
        right.add(refresh_button, BorderLayout.SOUTH);
        right.add(now, BorderLayout.NORTH);
        watt.setVisible(true);
        
        refresh_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try{
                    ZonedDateTime dateandtime = ZonedDateTime.now();
                    double[] coordinates = getLocation();
                    now.setText("Today is "+dateandtime.format(DateTimeFormatter.ofPattern("M/d/uuuu"))+", and we currently have "+codetoweather(getCurrentWeather(coordinates[0], coordinates[1]))+".");
                    model.clear();
                    int[] jeremy = getForecast(coordinates[0], coordinates[1]);
                    for(int i=0; i<jeremy.length; i++){
                        model.addElement(codetoweather(jeremy[i]));
                    }
                } catch(Exception a){
                    now.setText("Error: "+a);
                }
                watt.revalidate();
            }
        }); 
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
    public static String codetoweather(int code){
        switch (code) {
            case 0: return "sunny and clear skies";
            case 1: return "mainly clear skies";
            case 2: return "partly cloudy skies";
            case 3: return "overcast skies";
            case 45: return "fog";
            case 48: return "fog";
            case 51: return "light drizzle";
            case 52: return "moderate drizzle";
            case 53: return "intense drizzle";
            case 56: return "light freezing drizzle";
            case 57: return "intense freezing drizzle";
            case 61: return "slight rain";
            case 62: return "moderate rain";
            case 63: return "heavy rain";
            case 66: return "light freezing rain";
            case 67: return "heavy freezing rain";
            case 71: return "slight snow fall";
            case 72: return "moderate snow fall";
            case 73: return "heavy snow fall";
            case 77: return "snow grains";
            case 80: return "slight rain showers";
            case 81: return "moderate rain showers";
            case 82: return "violent rain showers";
            case 85: return "slight snow showers";
            case 86: return "heavy snow showers";
            case 95: return "thunderstorm";
            case 96: return "thunderstorm with light hail";
            case 99: return "thunderstorm with heavy hail";
            default: return "Error";
        }
 
    }
    public static double[] getLocation(){
        return Locater.find();
    }
}