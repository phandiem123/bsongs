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

public class AdminDelContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminDelContactController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		if (session.getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath() + "/auth/login");
			return;
		}

		int contactId = Integer.parseInt(request.getParameter("contactId"));
		ContactDao contactDao = new ContactDao();

		if (contactDao.deleteById(contactId) > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/contact/index?msg=delok");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

	}

}
