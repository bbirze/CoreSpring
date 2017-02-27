package com.oaktreeair.ffprogram;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("flier01")
public class Flier {

	@Value("Sam Smith")
	private String flierName;
	
	@Value("1234")
	private Long flierID;
	
	@Resource(name="contact01")
	private ContactInfo contactInfo;
	
	public enum Level { Member, Gold, Platinum };
	private Level level;
	
	private ArrayList<Segment> segments = new ArrayList<Segment>();
	
	public String getFlierName() {
		System.out.println("In Flier getFlier() method");
		return flierName;
	}
	public void setFlierName(String flierName) {
		this.flierName = flierName;
	}
	public ArrayList<Segment> getSegments() {
		return segments;
	}
	public void addSegment(Segment seg)
	{
	segments.add(seg);
	}
	public Long getFlierID() {
		return flierID;
	}
	public void setFlierID(Long flierID) {
		this.flierID = flierID;
	}
	public ContactInfo getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "Flier [flierName=" + flierName + ", flierID=" + flierID + ", contactInfo=" + contactInfo + ", level="
				+ level + ", segments=" + segments + "]";
	}
	
}
