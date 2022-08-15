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


@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		String paramName = request.getParameter("name");
		String paramDate = request.getParameter("date");
		Integer id = Integer.valueOf(paramId);
		
		Date dateCreated = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dateCreated = sdf.parse(paramDate);
		}catch(ParseException e) {
			throw new ServletException(e);
		}
		
		FakeDatabase fd = new FakeDatabase();
		Company compUpdated = fd.getCompanyById(id);
		compUpdated.setName(paramName);
		compUpdated.setDateCreated(dateCreated);
		
		request.setAttribute("company", compUpdated.getName());
		response.sendRedirect("readServlet");
		
	}
}
