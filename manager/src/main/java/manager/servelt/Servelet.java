package manager.servelt;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import manager.entities.Company;
import manager.entities.FakeDatabase;

@WebServlet(urlPatterns = "/list")
public class Servelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FakeDatabase banco = new FakeDatabase();
		List<Company> list = banco.getEmpresa();
		
		Company company1 = new Company();
		company1.setName("Alura");

	    Company company2 = new Company();
	    company2.setName("Caelum");

	    list.add(company1);
	    list.add(company2);

		request.setAttribute("company", list);
		
		//Mandando pro JSP
		RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
		rd.forward(request, response);
	}
}
