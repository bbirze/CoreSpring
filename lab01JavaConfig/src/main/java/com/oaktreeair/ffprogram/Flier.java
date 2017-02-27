package com.oaktreeair.ffprogram;

import java.util.ArrayList;

public class Flier {

	private String flierName;

	private Long flierID;

	private ContactInfo contactInfo;
	
	public enum Level { Member, Gold, Platinum };
	private Level level;
	
	private ArrayList<Segment> segments = new ArrayList<Segment>();
	
	public String getFlierName() {
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
