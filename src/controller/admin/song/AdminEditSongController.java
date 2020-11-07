package controller.admin.song;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CatDao;
import dao.SongsDao;
import model.Categories;
import model.Songs;
import util.FileUtil;

@MultipartConfig
public class AdminEditSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminEditSongController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath() + "/auth/login");
			return;
		}
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		if (request.getParameter("songId") != null) {
			int songId = Integer.parseInt(request.getParameter("songId"));
			SongsDao songsDao = new SongsDao();
			Songs objSong = songsDao.findByIdSong(songId);
			request.setAttribute("objSong", objSong);
		}
		CatDao catDao = new CatDao();
		List<Categories> listCat = catDao.findAll();
		request.setAttribute("listCat", listCat);

		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/song/edit.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		SongsDao songsDao = new SongsDao();

		int idSong = Integer.parseInt(request.getParameter("idSong"));
		String name = request.getParameter("name");
		String des = request.getParameter("preview");
		String detail = request.getParameter("detail");
		int catId = Integer.parseInt(request.getParameter("category"));
		System.out.println(idSong);
		System.out.println(name);
		System.out.println(des);
		System.out.println(detail);
		System.out.println(catId);

		// lay du lieu
//		Songs song = songsDao.findByIdSong(44);
		// upload File
		String picture = FileUtil.upload("picture", request);
//		
//		System.out.println("picture: "+picture);
		// Insert vao Databaste

		Songs songs = new Songs(idSong, name, des, detail, picture, new Categories(catId));
		int edit = songsDao.editSong(songs);
		if (edit > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/song/index?msg=ok");
			return;
		}
		// thất bại
		request.setAttribute("songs", songs);
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/song/index.jsp");
		rd.forward(request, response);
	}

}
