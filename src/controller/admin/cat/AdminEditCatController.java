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

public class AdminEditCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminEditCatController() {
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
		int catId = Integer.parseInt(request.getParameter("catId"));
		// System.out.println(catId);
		CatDao catDao = new CatDao();
		Categories itemCat = catDao.findById(catId);
		// System.out.println(itemCat.getId());
		request.setAttribute("itemCat", itemCat);

		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/cat/edit.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		int catId = Integer.parseInt(request.getParameter("catId"));
		String nameCat = request.getParameter("nameCat");

		Categories itemCat = new Categories(catId, nameCat);
		// System.out.println(itemCat);
		CatDao catDao = new CatDao();
		if (catDao.editCat(itemCat) > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/cat/index?msg=editok");
		}
	}

}
