package com.realtimeweather.controller;

import java.io.IOException;
import java.util.Date;

import com.realtimeweather.dto.ClimateDTO;
import com.realtimeweather.service.ClimateService;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")
public class FrontController {

    private final ClimateService climateService = new ClimateService();

    @RequestMapping(method = RequestMethod.GET)
    public String getMainPage() {
        return "index";
    }

    @RequestMapping(value = "/weather/{city}", method = RequestMethod.POST)
    public @ResponseBody JSONObject weather(
            @PathVariable(value = "city") String city) throws IOException, ParseException {
    	JSONObject json = new JSONObject();
        ClimateDTO climate =  climateService.getWeather(city);
        json.put("temperature", climate.getTemperature());
        json.put("city", climate.getCity());
        json.put("description", climate.getWeather());
        json.put("wind", climate.getWind());
        Date dt = new Date();
        json.put("updatedTime",dt.toString());
        return json;
    }
}
