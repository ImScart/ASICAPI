package com.example.APITest;

public class JsonData
{
    private String message;
    private String unixTime;
    
    public JsonData(String message)
    {
        this.message=message;
        setUnixTime();
    }

    public String getMessage()
    {
        return message;
    }
    public void setMessage(String message)
    {
        this.message=message;
    }

    public String getUnixTime()
    {
        return unixTime;
    }
    public void setUnixTime()
    {
        unixTime=getUnixString();
    }



    public static String getUnixString()
    {
        String ut2 = Long.toString(System.currentTimeMillis() / 1000L);
        return ut2;
    }
}