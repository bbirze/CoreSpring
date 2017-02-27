package servlets;

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

import com.oaktreeair.ffprogram.ContactInfo;
import com.oaktreeair.ffprogram.Flier;

/**
 * Servlet implementation class DisplayFlier
 */
@WebServlet("/DisplayFlier")
public class DisplayFlier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		WebApplicationContext ctx = 
				WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

		Flier flier01 = (Flier) ctx.getBean("flier01");
		ContactInfo inf = flier01.getContactInfo();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println("In DisplayFlier Servlet doGet method");
		
		out.println("<html><body>");
		out.println("<p>Flier name: " + flier01.getFlierName() + "</p>");
		out.println("<p>Flier ID: " + flier01.getFlierID() + "</p>");
		out.println("<p>Flier email: " + inf.getEmailAddress() + "</p>");
		out.println("</body></html>");

		out.close();
	}

}
