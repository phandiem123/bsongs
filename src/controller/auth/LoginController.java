package controller.auth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;
import util.StringUtil;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/view/auth/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDao userDao = new UserDao();

		String username = request.getParameter("username");
		String password = StringUtil.md5(request.getParameter("password"));
		
		User userInfo = userDao.findByUsernameAndPassword(username, password);
		
		if (userInfo != null) {
			System.out.println(123);
			// đăng nhập đúng // lưuthông tin đăng nhập vào session.
//			HttpSession session = request.getSession();
//			session.setAttribute("userInfo", userInfo); // chuyển hướng
//			response.sendRedirect(request.getContextPath() + "/admin/index");
			return;
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/view/auth/login.jsp");
			rd.forward(request, response);
			return;
		}

	}

}
