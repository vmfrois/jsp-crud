package manager.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		
		System.out.println("Add new company");
		
		//Add company
		String nameCompany = request.getParameter("name");
		Company comp = new Company();
		comp.setName(nameCompany);
		
		//Save in Fake database
		FakeDatabase fd = new FakeDatabase();
		fd.add(comp);
		
		// Send to JSP
		RequestDispatcher rd = request.getRequestDispatcher("/newCompany.jsp"); //where to send
		request.setAttribute("company", comp.getName());
		rd.forward(request, response); // Send to JSP
		
		
	}
	
}
