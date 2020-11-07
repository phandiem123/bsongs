package controller.admin.cat;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CatDao;
import model.Categories;

public class AdminSearchCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminSearchCatController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CatDao  catDao = new CatDao();
		String search = request.getParameter("search");
		System.out.println(search);
		
		List<Categories> lisCategories = catDao.searchAllCatByTextSearch(search);
		
		request.setAttribute("lisCategories", lisCategories);
		
		RequestDispatcher rd = request.getRequestDispatcher("view/admin/cat/search.jsp");
		rd.forward(request, response);
	}

}
