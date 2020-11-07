package controller.publics.song;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SongsDao;
import model.Songs;

public class PublicNewSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicNewSongController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SongsDao songsDao = new SongsDao();

		int countPage = songsDao.getCountNewSong();
		request.setAttribute("countPage", countPage);

		String page = request.getParameter("page");
		if (page == null) {
			page = "1";
		}
		int pageIndex = Integer.parseInt(page);
		List<Songs> listPage = songsDao.getAllSongsInPage(pageIndex);
		request.setAttribute("listPage", listPage);

		request.getRequestDispatcher("/view/public/song/new100Song.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
