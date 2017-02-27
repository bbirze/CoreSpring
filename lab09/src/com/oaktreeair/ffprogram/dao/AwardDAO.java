package com.oaktreeair.ffprogram.dao;

import java.util.Collection;

import com.oaktreeair.ffprogram.Award;
import com.oaktreeair.ffprogram.Flier;

public interface AwardDAO
{
    public int insertAward(Flier flier, Award award);
    public void updateAward(Award award);
    public Collection<Award> findAwardsForFlier(Long flierID);
}
