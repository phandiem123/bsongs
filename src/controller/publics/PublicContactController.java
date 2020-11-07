package controller.publics;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactDao;
import model.Contacts;

public class PublicContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicContactController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		ContactDao contactDao = new ContactDao();
		List<Contacts> listContact = contactDao.findAll();
		
		request.setAttribute("listContact", listContact);
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/public/contact.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String website = request.getParameter("website");
		String message = request.getParameter("message");
		Contacts contacts = new Contacts(0, name, email, website, message);
		ContactDao contactDao = new ContactDao();
		int add = contactDao.addContact(contacts);
		if (add > 0) {
			response.sendRedirect(request.getContextPath()+"/index?msg=addContactOk");
			return; 
		}
//		request.setAttribute("name", name);
//		request.setAttribute("email", email);
//		request.setAttribute("website", website);
//		request.setAttribute("message", message);
//
//		RequestDispatcher rd = request.getRequestDispatcher("/view/public/contact.jsp");
//		rd.forward(request, response);
	}

}
