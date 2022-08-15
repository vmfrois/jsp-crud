package manager.servlet.crud;

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


@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    			throws ServletException, IOException {
    		
    		//Get parameter
    		String companyName = request.getParameter("name");
    		String companyDate = request.getParameter("date");
    		
    		//Formating a date String -> Date
    		Date dateCreated = null;
    		try {
    			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    			dateCreated = sdf.parse(companyDate);
    		}catch(ParseException e) {
    			throw new ServletException(e);
    		}
    		
    		//Add Company
    		Company company = new Company();
    		company.setName(companyName);
    		company.setDateCreated(dateCreated);
    		
    		//Add in Fake database
    		FakeDatabase fd = new FakeDatabase();
    		fd.add(company);
    		
    		//Request to Servlet
    		request.setAttribute("company",company.getName());
 
   		
    		//response to Servlet
    		response.sendRedirect("readServlet");
    		
    	} 	
}
