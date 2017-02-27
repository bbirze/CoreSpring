package com.oaktreeair.ffprogram;

import java.util.Collection;
import java.util.HashSet;

public class Flier
{
    private Long flierID;
    private String name;
    private int mileageBalance;

    private Collection<Award> awards = new HashSet<Award>();

    public Collection<Award> getAwards()
    {
        return awards;
    }

    public void setAwards(Collection<Award> awards)
    {
        this.awards = awards;
    }

    public Long getFlierID()
    {
        return flierID;
    }

    public void setFlierID(Long flierID)
    {
        this.flierID = flierID;
    }

    public int getMileageBalance()
    {
        return mileageBalance;
    }

    public void setMileageBalance(int mileageBalance)
    {
        this.mileageBalance = mileageBalance;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
