package com;
import org.json.JSONObject;
public class Geocode
{

    private final String coordinates;
    public Geocode(String coordinates)
    {
        this.coordinates = coordinates;
    }
    public String getGeocode()
    {
        return coordinates;
    }

}
