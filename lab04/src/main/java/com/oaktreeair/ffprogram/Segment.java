package com.oaktreeair.ffprogram;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("seg01")
public class Segment {
	@Value("88")
	private Long segmentNumber;
	private Date segmentDate;

	@Value("1234")
	private int flightNumber;

	@Value("Dallas")
	private String originatingCity;

	@Value("1000")
	private int miles;

	@PostConstruct
	public void init() {
		try { // write random number to temp file
			System.out.println("In Segment.init() method");
			Random rand = new Random();
			long randID = rand.nextLong();
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("temp.dat"));
			dos.writeLong(randID);
			dos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@PreDestroy
	public void destroy()  {
		System.out.println("In Segment.destroy() method");
		File temp = new File("temp.dat");
		temp.delete();
	}

	public Long getSegmentNumber() {
		Long segNum = null;
		try {
			DataInputStream dis = 
					new DataInputStream(new FileInputStream("temp.dat"));
			long val = dis.readLong();
			segNum = val;
			dis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return segNum;
	}

	public void setSegmentNumber(Long segmentNumber) {
		this.segmentNumber = segmentNumber;
	}

	public Date getSegmentDate() {
		return segmentDate;
	}

	public void setSegmentDate(Date segmentDate) {
		this.segmentDate = segmentDate;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getOriginatingCity() {
		return originatingCity;
	}

	public void setOriginatingCity(String originatingCity) {
		this.originatingCity = originatingCity;
	}

	public int getMiles() {
		return miles;
	}

	public void setMiles(int miles) {
		this.miles = miles;
	}

	@Override
	public String toString() {
		return "Segment [segmentNumber=" + segmentNumber + ", segmentDate=" + segmentDate + ", flightNumber="
				+ flightNumber + ", originatingCity=" + originatingCity + ", miles=" + miles + "]";
	}

}
