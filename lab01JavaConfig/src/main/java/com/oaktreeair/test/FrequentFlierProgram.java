package com.oaktreeair.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.oaktreeair.ffprogram.BonusCalc;
import com.oaktreeair.ffprogram.ContactInfo;
import com.oaktreeair.ffprogram.Flier;
import com.oaktreeair.ffprogram.Segment;

public class FrequentFlierProgram {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(FrequentFlierConfig.class);

		Flier flier01 = (Flier) ctx.getBean("flier01");
		System.out.println(flier01.getFlierName());
		System.out.println(flier01.getFlierID());

		ContactInfo inf = flier01.getContactInfo();
		System.out.println(inf.getEmailAddress());

		flier01.setLevel(Flier.Level.Gold);

		Segment seg01 = (Segment) ctx.getBean("seg01");
		flier01.addSegment(seg01);

		BonusCalc bc = (BonusCalc) ctx.getBean("calcBonus");
		System.out.println("Bonus Calculation: " + bc.calcBonus(flier01, seg01));

		ctx.close();
	}

}
