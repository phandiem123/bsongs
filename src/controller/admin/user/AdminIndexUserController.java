package controller.admin.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

public class AdminIndexUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminIndexUserController() {
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
		UserDao userDao = new UserDao();
		List<User> listUser = userDao.findAll();
		request.setAttribute("listUser", listUser);

		HttpSession userInfo = request.getSession();
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/user/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
