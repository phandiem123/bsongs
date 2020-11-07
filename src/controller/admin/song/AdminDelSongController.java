package controller.admin.song;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import constants.GlobalConstant;
import dao.CatDao;
import dao.SongsDao;
import model.Categories;
import model.Songs;
import util.FileUtil;

public class AdminDelSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminDelSongController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath() + "/auth/login");
			return;
		}
		SongsDao songsDao = new SongsDao();
		int songId = Integer.parseInt(request.getParameter("songId"));
		// kiem tra co file
		Songs songs = songsDao.findByIdSong(songId);
		String picture = songs.getPicture();

		FileUtil.delFile(picture, request);
		// xoa tin

		if (songsDao.deleteById(songId) > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/song/index?msg=delok");
		}
		// RequestDispatcher rd =
		// request.getRequestDispatcher("/view/admin/song/index.jsp");
		// rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
