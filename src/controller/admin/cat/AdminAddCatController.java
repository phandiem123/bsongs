package controller.admin.cat;

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
import model.Categories;

public class AdminAddCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminAddCatController() {
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
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/cat/add.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		CatDao catDao = new CatDao();
		String name = request.getParameter("name");
		Categories cat = new Categories(0, name);
		int add = catDao.addCat(cat);
		if (add > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/cat/index?msg=ok");
			return;
		}
		// thất bại
		request.setAttribute("cat", cat);
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/cat/add.jsp");
		rd.forward(request, response);
	}

}
