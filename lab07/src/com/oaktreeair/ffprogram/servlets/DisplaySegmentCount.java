package com.oaktreeair.ffprogram.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.oaktreeair.ffprogram.dao.SegmentDao;

/**
 * Servlet implementation class DisplaySegmentCount
 */
@WebServlet("/DisplaySegmentCount")
public class DisplaySegmentCount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplaySegmentCount() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext servletContext = getServletContext();
		WebApplicationContext ctx = 
				WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		
		SegmentDao dao = (SegmentDao)ctx.getBean("segmentDao");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		out.println("<p>Segment count: " +
		dao.getSegmentCount() + "</p>");
		out.println("</body></html>");
	}

}
