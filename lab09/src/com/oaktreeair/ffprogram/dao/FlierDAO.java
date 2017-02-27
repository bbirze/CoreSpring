package com.oaktreeair.ffprogram.dao;

import com.oaktreeair.ffprogram.Flier;

public interface FlierDAO
{
    public Flier findFlierByID(Long flierID);
    public void updateFlier(Flier flier);
}
