package com.oaktreeair.ffprogram;

import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Segment {

	private Long segmentNumber;
	private Date segmentDate;
	private int flightNumber;
	private String originatingCity;
	private int miles;
	private DocumentBuilder parser;

	public void init() {
		try {

			Document doc = parser.parse("flights.xml");
			StringBuilder sb = new StringBuilder();
			sb.append("/flights/flight[@flightNumber='");
			sb.append(flightNumber);
			sb.append("']/segments/segment[@startCity='");
			sb.append(originatingCity);
			sb.append("']/miles");
			String xpathStr = sb.toString();
			System.out.println("XPath String: " + xpathStr);

			XPath xpath = XPathFactory.newInstance().newXPath();
			XPathExpression expr;
			expr = xpath.compile(xpathStr);

			Object result = expr.evaluate(doc, XPathConstants.NODESET);
			NodeList nodes = (NodeList)result;
			Node node = nodes.item(0);
			miles = Integer.parseInt(node.getTextContent());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public DocumentBuilder getParser() {
		return parser;
	}

	public void setParser(DocumentBuilder parser) {
		this.parser = parser;
	}

	public Long getSegmentNumber() {
		return segmentNumber;
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
