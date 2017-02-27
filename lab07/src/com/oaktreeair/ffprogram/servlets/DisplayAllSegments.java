package com.oaktreeair.ffprogram.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

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
 * Servlet implementation class DisplayAllSegments
 */
@WebServlet("/DisplayAllSegments")
public class DisplayAllSegments extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DisplayAllSegments() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		ServletContext servletContext = getServletContext();
		WebApplicationContext ctx = 
				WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		
		try  {
		SegmentDao dao = (SegmentDao)ctx.getBean("segmentDao");
		Collection<Segment> segs = dao.findAllSegments();
		
		out.println("<html><body>");
		out.println("<p>Displaying " + segs.size() + " segments: ");
		out.println("<table border='1'>");
		
		for(Segment s: segs) {
			out.println("<tr>");
			out.println("<td> " + s.getSegmentNumber() + "</td>");
			out.println("<td> " + s.getSegmentDate() + "</td>");
			out.println("<td> " + s.getFlightNumber() + "</td>");
			out.println("<td> " + s.getOriginatingCity() + "</td>");
			out.println("<td> " + s.getMiles() + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body></html>");
		} catch(Exception e)  {
			out.println("Display All Segments Got exception: " + e.getMessage());
		}
	}

}
