package controller.publics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SongsDao;
import model.Songs;

public class PublicCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicCatController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		int idCat = Integer.parseInt(request.getParameter("idCat"));

		SongsDao songsDao = new SongsDao();

		String page = request.getParameter("page");
		if (page == null) {
			page = "1";
		}
		int pageIndex = Integer.parseInt(page);
		List<Songs> listSongsByIdCat = songsDao.findByIdCat(idCat, pageIndex);
		int countPage = songsDao.getCountByIdCat(idCat);

		request.setAttribute("countPage", countPage);
		System.out.println(countPage);
		request.setAttribute("listSongsByIdCat", listSongsByIdCat);
		RequestDispatcher rd = request.getRequestDispatcher("/view/public/cat.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
