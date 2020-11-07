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
import dao.SongsDao;
import model.Categories;

public class AdminDelCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminDelCatController() {
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
		System.out.println(catId);

		CatDao catDao = new CatDao();
		SongsDao songsDao = new SongsDao();
		if ((catDao.deleteById(catId)>0 )&&(songsDao.deleteByIdCat(catId)>0)) {
			response.sendRedirect(request.getContextPath() + "/admin/cat/index?msg=3");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

	}

}
