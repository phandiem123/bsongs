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

public class AdminIndexContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminIndexContactController() {
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
		// System.out.println(request.getServletContext().getRealPath(""));
		ContactDao contactDao = new ContactDao();
		List<Contacts> contactList = new ArrayList<Contacts>();
		contactList = contactDao.findAll();
		// System.out.println(catList.size());
		request.setAttribute("contactList", contactList);

		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/contact/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
