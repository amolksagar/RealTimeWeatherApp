package com.realtimeweather.service;

import junit.framework.*;
import com.realtimeweather.dto.ClimateDTO;
import com.realtimeweather.service.ClimateService;

public class ClimateServiceTest  extends TestCase{

	 /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ClimateServiceTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite(){
        return new TestSuite( ClimateServiceTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp(){
    	ClimateService climateService = new ClimateService();
    	try {
    		ClimateDTO climateDTO =climateService.getWeather("Sydney");
    		assertTrue(climateDTO!=null);
    		assertTrue(climateDTO.getCity()!=null);
    		assertTrue(climateDTO.getCity().contains("Sydney"));
    		assertTrue(climateDTO.getTemperature()!=null);
    		Integer.parseInt(climateDTO.getTemperature());
    		assertTrue(climateDTO.getWeather()!=null);
    		assertTrue(climateDTO.getWind()!=null);
		} catch (Exception e) {
			assertFalse(true);
		} 
    }
}
