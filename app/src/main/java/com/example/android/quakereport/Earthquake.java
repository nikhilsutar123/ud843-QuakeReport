package com.example.android.quakereport;

public class Earthquake {

    /**
     * Constructs a new {@link Earthquake} object.
     *
     * @param Mag is the magnitude (size) of the earthquake
     * @param city is the location where the earthquake happened
     * @param TimeInMillis is the time in milliseconds (from the Epoch) when the
     *                           earthquake happened
     */
    private double Mag;
    private String city, url;
    private long TimeInMillis;

    public Earthquake(){}

   public Earthquake(double Maglevel, String cityName, long millisec, String mUrl)
    {
        Mag = Maglevel;
        city = cityName;
        TimeInMillis  = millisec;
        url = mUrl;
    }

    public double getMag(){
       return Mag;
    }

    public String getCity(){
       return city;
    }

    public long getDate(){
       return TimeInMillis;
    }

    public String getUrl(){return url;}

}
