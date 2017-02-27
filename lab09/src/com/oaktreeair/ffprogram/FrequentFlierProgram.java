package com.oaktreeair.ffprogram;

public interface FrequentFlierProgram
{
    public Flier findFlierByID(int flierID);
    public boolean redeemMiles(int flierID, 
            int miles, String awardDescription);
}
