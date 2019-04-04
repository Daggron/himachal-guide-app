package com.example.himachalguide;

public class places {
    private String Mname;
    private String MLocation;
    private String Mdescription;
    private int mImage;

    public places(String name,String location,String description, int image){

        mImage=image;
        Mname=name;
        MLocation=location;
        Mdescription=description;


    }

    public String getMname(){
        return Mname;
    }

    public String getMLocation(){
        return MLocation;
    }

    public String getMdescription(){
        return Mdescription;

    }
    public int getmImage(){
        return mImage;
    }
}
