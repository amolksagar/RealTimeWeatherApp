package com.realtimeweather.helper;

import com.realtimeweather.dto.ClimateDTO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParsingHelper {

    private String jsonToParsing;
    private final JSONParser parser = new JSONParser();

    public void setJsonToParsing(String jsonToParsing) {
        this.jsonToParsing = jsonToParsing;
    }

    public ClimateDTO getWeather() throws ParseException {
    	ClimateDTO climate = new ClimateDTO();
        Object obj = parser.parse(jsonToParsing);
        JSONObject mainJsonObj = (JSONObject) obj;
        JSONObject mainArray = (JSONObject) mainJsonObj.get("main");
        JSONObject windArray = (JSONObject) mainJsonObj.get("wind");
        JSONObject countryObject = (JSONObject) mainJsonObj.get("sys");
        JSONArray weatherArray = (JSONArray) mainJsonObj.get("weather");
        JSONObject descriptionObject = (JSONObject) weatherArray.get(0);
        climate.setCity(getCityDescription(mainJsonObj, countryObject));
        climate.setWeather(String.valueOf(
                descriptionObject.get("description")));
        climate.setTemperature(getTemperatureDescription(mainArray));
        climate.setWind(getWindDescription(windArray));
        return climate;
    }

    private String getCityDescription(JSONObject jsonObject,
                                      JSONObject countryObject) {
        return String.valueOf(jsonObject.get("name"))
                .concat(", ")
                .concat(String.valueOf(countryObject.get("country")));
    }

    private String getTemperatureDescription(JSONObject jsonObject) {
    	String tempDesc=String.valueOf(
    			((Double)jsonObject.get("temp") - Constants.KELVIN_CELSIUS_DIFFERENCE));
    	return tempDesc.substring(0, tempDesc.indexOf('.'));
    }

    private String getWindDescription(JSONObject jsonObject) {
        return String.valueOf(jsonObject.get("speed")).concat(" m/s");
    }
}
