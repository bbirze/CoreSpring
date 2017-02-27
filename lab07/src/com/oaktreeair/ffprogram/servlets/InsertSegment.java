package com.oaktreeair.ffprogram.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.oaktreeair.ffprogram.Segment;
import com.oaktreeair.ffprogram.dao.SegmentDao;

/**
 * Servlet implementation class InsertSegment
 */
@WebServlet("/InsertSegment")
public class InsertSegment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InsertSegment() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		ServletContext servletContext = getServletContext();
		WebApplicationContext ctx = 
				WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		
		try  {
		SegmentDao dao = (SegmentDao)ctx.getBean("segmentDao");
		Segment s = new Segment();
		s.setFlightNumber(Integer.parseInt(request.getParameter("flightNumber")));
		s.setOriginatingCity(request.getParameter("originatingCity"));
		s.setMiles(Integer.parseInt(request.getParameter("miles")));

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		s.setSegmentDate(df.parse(request.getParameter("segmentDate")));
		
		int segNum = dao.insertSegment(s);
		
		out.println("<html><body>");
		out.println("<p>Inserted Segment with id " + segNum);

		out.println("</table>");
		out.println("</body></html>");
		} catch(Exception e)  {
			out.println("Display All Segments Got exception: " + e.getMessage());
		}
	}

}
