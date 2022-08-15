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


@WebServlet("/getCompanyServlet")
public class GetCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
			
		FakeDatabase fd = new FakeDatabase();
		Company compUpdated = fd.getCompanyById(id);
	

		RequestDispatcher rd = request.getRequestDispatcher("updateForm.jsp");
		request.setAttribute("company",compUpdated);
		rd.forward(request, response);
	}

	
}
