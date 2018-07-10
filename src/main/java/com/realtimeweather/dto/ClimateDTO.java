package com.realtimeweather.dto;

public class ClimateDTO {
	private String city;
    private String weather;
    private String temperature;
    private String wind;
    
    public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
    public String getCity() {
		return city;
	}
	public String getTemperature() {
		return temperature;
	}
	public String getWind() {
		return wind;
	}
    public void setCity(String city) {
        this.city = city;
    }
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
    public void setWind(String wind) {
        this.wind = wind;
    }
}
