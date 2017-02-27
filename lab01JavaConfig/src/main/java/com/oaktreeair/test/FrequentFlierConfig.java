package com.oaktreeair.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.oaktreeair.ffprogram.BonusCalc;
import com.oaktreeair.ffprogram.BonusCalcImpl;
import com.oaktreeair.ffprogram.ContactInfo;
import com.oaktreeair.ffprogram.Flier;
import com.oaktreeair.ffprogram.Segment;

@Configuration
public class FrequentFlierConfig {

	@Bean(name="seg01")
	public Segment getSeg01() {
		Segment seg = new Segment();
		seg.setFlightNumber(2238);
		seg.setMiles(1000);
		seg.setOriginatingCity("ORD");
		seg.setSegmentNumber(1234L);
		return seg;
	}
	
	@Bean(name="contact01")
	public ContactInfo getContact01()  {
		ContactInfo co = new ContactInfo();
		co.setEmailAddress("sSmith@gmail.com");
		co.setHomePhone("294.444.3333");
		co.setMobilePhone("214.555.9898");
		co.setSmsNumber("214.555.9898");
		return co;
	}
	
	@Bean(name="calcBonus")
	public BonusCalc getCalcBonus()  {
		return new BonusCalcImpl();
	}
	
	@Bean(name="flier01")
	public Flier getFlier01()  {
		Flier f = new Flier();
		f.setContactInfo(getContact01());
		f.setFlierID(45675L);
		f.setFlierName("Sam Smith");
		f.setLevel(Flier.Level.Gold);
		return f;
	}

}
