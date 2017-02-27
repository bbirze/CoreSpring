package com.oaktreeair.ffprogram.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.oaktreeair.ffprogram.Award;
import com.oaktreeair.ffprogram.Flier;
import com.oaktreeair.ffprogram.FrequentFlierProgram;

@SuppressWarnings("serial")
@WebServlet("/AwardServlet")
public class AwardServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		ServletContext servletContext = getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

		FrequentFlierProgram ffp = (FrequentFlierProgram) ctx.getBean("frequentFlierProgram");

		Flier f = ffp.findFlierByID(1);
		out.println("<p>Balance before award: " + f.getMileageBalance() + "</p>");

		Collection<Award> awards = f.getAwards();
		out.println("<table border='1'>");
		for (Award a : awards) {
			out.println("<tr>");
			out.println("<td>" + a.getDescription() + "</td>");
			out.println("<td>" + a.getMilesRequired() + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");

		boolean ok = ffp.redeemMiles(1, 3000, "BOS-SEA");
		out.println("<p>Award redeemed OK? " + ok + "</p>");

		f = ffp.findFlierByID(1);
		out.println("<p>Balance after award: " + f.getMileageBalance() + "</p>");
		awards = f.getAwards();
		out.println("<table border='1'>");
		for (Award a : awards) {
			out.println("<tr>");
			out.println("<td>" + a.getDescription() + "</td>");
			out.println("<td>" + a.getMilesRequired() + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");

	}
}