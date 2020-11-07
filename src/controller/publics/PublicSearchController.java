package controller.publics;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constants.GlobalConstant;
import dao.CatDao;
import dao.SongsDao;
import model.Categories;
import model.Songs;
import util.PageUtil;

public class PublicSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicSearchController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SongsDao songsDao = new SongsDao();
		String editboxSearch =  request.getParameter("editbox_search");
		int idCat= Integer.parseInt(request.getParameter("idCat"));
		
		if(idCat==0) {
			List<Songs> listSongs = songsDao.findAllSongLikeTextSearch(editboxSearch);
			request.setAttribute("listSongs", listSongs);
		} else {
			List<Songs> listSongs = songsDao.searchAllSongByIdCat(idCat, editboxSearch);
			request.setAttribute("listSongs", listSongs);
		}
		
		int count = songsDao.getCount();
		int endPage = PageUtil.getEndPage(count);
		
		request.setAttribute("endPage", endPage);
		request.getRequestDispatcher("view/public/search.jsp").forward(request, response);
	}

}
