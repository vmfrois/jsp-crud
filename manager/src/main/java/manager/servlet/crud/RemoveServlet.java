package manager.servlet.crud;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.entities.Company;
import manager.entities.FakeDatabase;


@WebServlet("/RemoveServlet")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		FakeDatabase fd = new FakeDatabase();
		Company compRemoved = fd.removeCompany(id);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/removeCompany.jsp");
		request.setAttribute("company",compRemoved.getName());
		rd.forward(request, response);
	
	}
}
