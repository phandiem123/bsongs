package controller.admin.contact;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CatDao;
import dao.ContactDao;
import model.Categories;
import model.Contacts;

public class AdminRepContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminRepContactController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath() + "/auth/login");
			return;
		}
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		int contactId = Integer.parseInt(request.getParameter("contactId"));
		ContactDao contactDao = new ContactDao();
		Contacts contacts = contactDao.findById(contactId);

		request.setAttribute("contacts", contacts);
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/contact/rep.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		ContactDao contactDao = new ContactDao();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String website = request.getParameter("website");
		String message = request.getParameter("message");

		int contactId = Integer.parseInt(request.getParameter("id"));

		int del = contactDao.deleteById(contactId);

		if (del > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/contact/index?msg=repok");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/contact/index.jsp");
		rd.forward(request, response);
	}

}
