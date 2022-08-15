package manager.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import manager.entities.Company;
import manager.entities.FakeDatabase;

@WebServlet(urlPatterns = "/listServlet")
public class ServletList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			FakeDatabase banco = new FakeDatabase();
			List<Company> list = banco.getAllCompany();
	
			request.setAttribute("companys", list);
			
			//Send to JSP
			RequestDispatcher rd = request.getRequestDispatcher("/list.jsp");
			rd.forward(request, response);
		}
}	
