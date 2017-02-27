package com.oaktreeair.ffprogram;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oaktreeair.ffprogram.dao.AwardDAO;
import com.oaktreeair.ffprogram.dao.FlierDAO;

@Service("frequentFlierProgram")
public class FrequentFlierProgramImpl implements FrequentFlierProgram {

	@Autowired
	private FlierDAO flierDAO;

	@Autowired
	private AwardDAO awardDAO;

	@Transactional(propagation = Propagation.REQUIRED)
	public Flier findFlierByID(int flierID) {
		Long id = new Long(flierID);

		Flier theFlier = flierDAO.findFlierByID(id);
		Collection<Award> awards = awardDAO.findAwardsForFlier(id);
		theFlier.setAwards(awards);

		return theFlier;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean redeemMiles(int flierID, int miles, String awardDescription) {
		boolean retVal = false;
		Long idFlier = new Long(flierID);
		
		Flier flier = flierDAO.findFlierByID(idFlier);
		int balance = flier.getMileageBalance();
		
		if (balance - miles >= 0) {		// create a new award and add to flier's award collection
			Award award = new Award();
			award.setMilesRequired(miles);
			award.setDescription(awardDescription);
			awardDAO.insertAward(flier, award);
			
			flier.setMileageBalance(balance - miles);        // reduce flier's balance
			flierDAO.updateFlier(flier);
			retVal = true;
		}
		return retVal;
	}

}
