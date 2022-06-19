package com.example.covid19cv;

public class DataBaseMuni
{
    public String municipality;
    public String symptoms;
    public String id;
    public String startDate;

    public DataBaseMuni(String muni,String symps, String id_1, String StrDt){
        municipality = muni;
        symptoms = symps;
        id = id_1;
        startDate = StrDt;


        return;
    }
}
