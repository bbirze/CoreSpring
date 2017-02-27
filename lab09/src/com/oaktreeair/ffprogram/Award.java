package com.oaktreeair.ffprogram;


public class Award
{
    private Long awardID;
    private String description;
    private int milesRequired;

    private Flier flier;

    public Long getAwardID()
    {
        return awardID;
    }

    public void setAwardID(Long awardID)
    {
        this.awardID = awardID;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Flier getFlier()
    {
        return flier;
    }

    public void setFlier(Flier flier)
    {
        this.flier = flier;
    }

    public int getMilesRequired()
    {
        return milesRequired;
    }

    public void setMilesRequired(int milesRequired)
    {
        this.milesRequired = milesRequired;
    }
}
