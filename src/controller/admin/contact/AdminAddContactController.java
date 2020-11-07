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

public class AdminAddContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminAddContactController() {
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

		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/contact/add.jsp");
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
		Contacts contacts = new Contacts(0, name, email, website, message);
		int add = contactDao.addContact(contacts);
		if (add > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/contact/index?msg=addok");
			return;
		}
		// thất bại
		// request.setAttribute("cat", cat);
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/cat/add.jsp");
		rd.forward(request, response);
	}

}
