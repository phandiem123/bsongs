package controller.admin.song;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import dao.CatDao;
import dao.SongsDao;
import model.Categories;
import model.Songs;

public class AdminIndexSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminIndexSongController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		HttpSession session  = request.getSession();
//		if(session.getAttribute("userInfo")!=null) {
//			response.sendRedirect("/auth/login");
//		}
		HttpSession session = request.getSession();

		if (session.getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath() + "/auth/login");
			return;
		}
		SongsDao songDao = new SongsDao();
		List<Songs> listSong = songDao.findAll();
		request.setAttribute("listSong", listSong);
		CatDao catDao = new CatDao();
		List<Categories> listCat = catDao.findAll();

		request.setAttribute("listCat", listCat);
		//System.out.println(listSong.size());
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/song/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
