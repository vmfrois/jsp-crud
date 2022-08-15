package manager.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.entities.Company;
import manager.entities.FakeDatabase;


@WebServlet(urlPatterns = "/ServlevtDateFmt")
public class ServlevtDateFmt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Get value the parameter 
		String nameCompany = request.getParameter("name"); // pega do jsp
		String date = request.getParameter("date");
		
		
		//Formating date (string for date)
		Date dateCreated = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dateCreated = sdf.parse(date);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		//Add new Company
		Company comp = new Company();
		comp.setName(nameCompany);
		comp.setDateCreated(dateCreated);
		
		//Save in Fake database
		FakeDatabase fd = new FakeDatabase();
		fd.add(comp);
		
		// Send to JSP
		RequestDispatcher rd = request.getRequestDispatcher("/newCompany.jsp");
		request.setAttribute("company", comp.getName());
		rd.forward(request, response);
		
		
	}

}
