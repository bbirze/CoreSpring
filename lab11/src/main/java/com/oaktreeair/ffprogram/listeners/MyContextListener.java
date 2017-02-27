package com.oaktreeair.ffprogram.listeners;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.oaktreeair.ffprogram.Segment;

@WebListener
public class MyContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		List<Segment> segments = new ArrayList<Segment>();
		
		Segment s = new Segment();
		s.setFlightNumber(5079);
		s.setMiles(345);
		s.setOriginatingCity("CID");
		s.setSegmentDate(new Date());
		s.setSegmentNumber((long) 12);
		segments.add(s);
		
		s = new Segment();
		s.setFlightNumber(2486);
		s.setMiles(2165);
		s.setOriginatingCity("SEA");
		s.setSegmentDate(new Date());
		s.setSegmentNumber((long) 13);
		segments.add(s);
		
		s = new Segment();
		s.setFlightNumber(1431);
		s.setMiles(1431);
		s.setOriginatingCity("ORD");
		s.setSegmentDate(new Date());
		s.setSegmentNumber((long) 14);
		segments.add(s);
		
		sce.getServletContext().setAttribute("segments", segments);
	}

}
