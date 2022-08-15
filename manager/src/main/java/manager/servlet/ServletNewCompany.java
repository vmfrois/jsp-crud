package manager.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.entities.Company;
import manager.entities.FakeDatabase;

@WebServlet(urlPatterns = "/newCompany")
public class ServletNewCompany extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException{
		
		//Get parameters
		String nameCompany = request.getParameter("name");
		String date = request.getParameter("date");
		
		
		//Set date formating
		Date dateCreated = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dateCreated = sdf.parse(date);
		}catch(ParseException e) {		
			throw new ServletException(e);
		}
		
		//Add company
		Company company = new Company();
		company.setName(nameCompany);
		company.setDateCreated(dateCreated);
		
		//Save in Fake database
		FakeDatabase fd = new FakeDatabase();
		fd.add(company);
		
		
		//Send to JSP - redirect to client side
		request.setAttribute("company", company.getName());
		
		response.sendRedirect("listServlet");
		
		// Send to JSP - redirect  to server side
		//RequestDispatcher rd = request.getRequestDispatcher("/listServlet"); //where to send
		//request.setAttribute("company", company.getName());
		//.forward(request, response); // Send to JSP

	}
	
}
