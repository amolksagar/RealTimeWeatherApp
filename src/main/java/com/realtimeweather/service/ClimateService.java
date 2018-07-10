package com.realtimeweather.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.realtimeweather.dto.ClimateDTO;
import com.realtimeweather.helper.ParsingHelper;

import org.json.simple.parser.ParseException;

public class ClimateService {

    private final ParsingHelper parser = new ParsingHelper();
    private final Pattern pattern = Pattern.compile("^*[^0-9/]*$");

    public ClimateDTO getWeather(String city) throws IOException, ParseException {
        if (!validate(city)) {
            throw new ParseException(0, city);
        }
        return getWeatherFromJson(getJsonFromServer(city));
    }

    private Boolean validate(String city) {
        Matcher matcher = pattern.matcher(city);
        return matcher.matches();
    }

    private ClimateDTO getWeatherFromJson(String json) throws ParseException {
        parser.setJsonToParsing(json);
        return parser.getWeather();
    }

    public String getJsonFromServer(String city) throws IOException {

        String result = "";
        URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q="
                + city
                + "&APPID=1634b0816e95a4ac3f2a6cd99a769eb2");
        URLConnection urlConnection = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                urlConnection.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            result += result.concat(inputLine);
        }
        in.close();
        return result;
    }

}
