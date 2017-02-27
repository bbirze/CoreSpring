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
		
		Segment seg01 = (Segment)ctx.getBean("seg01");

		System.out.println("Segment Number: " + seg01.getSegmentNumber());
		
		ctx.close();
	}

}
