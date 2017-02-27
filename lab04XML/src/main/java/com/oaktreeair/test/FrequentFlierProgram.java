package com.oaktreeair.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.oaktreeair.ffprogram.BonusCalc;
import com.oaktreeair.ffprogram.ContactInfo;
import com.oaktreeair.ffprogram.Flier;
import com.oaktreeair.ffprogram.Segment;

public class FrequentFlierProgram {

	public static void main(String[] args) {
		AbstractApplicationContext ctx =
				new FileSystemXmlApplicationContext("src/main/java/spring.xml");
		
		Flier flier01 = (Flier)ctx.getBean("flier01");
		System.out.println(flier01.getFlierName());
		System.out.println(flier01.getFlierID());
		
		ContactInfo inf = flier01.getContactInfo();
		System.out.println(inf.getEmailAddress());
		
		flier01.setLevel(Flier.Level.Gold);
		
		Segment seg01 = (Segment)ctx.getBean("seg01");
		flier01.addSegment(seg01);
		
		System.out.println("Segment Miles: " + seg01.getMiles());
		
		ctx.close();
	}

}
