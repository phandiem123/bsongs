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
public class AdminAddSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminAddSongController() {
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

		CatDao catDao = new CatDao();
		List<Categories> listCat = catDao.findAll();
		// System.out.println(listCat.size());
		request.setAttribute("listCat", listCat);

		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/song/add.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		SongsDao songsDao = new SongsDao();
		String name = request.getParameter("name");
		String des = request.getParameter("preview");
		String detail = request.getParameter("detail");
		int catId = Integer.parseInt(request.getParameter("category"));
		// upload File
		String fileName = FileUtil.upload("picture", request);
		// Insert vao Databaste
		Songs songs = new Songs(name, des, detail, fileName, new Categories(catId));
		if (songsDao.addSongs(songs) > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/song/index?msg=addok");
			return;
		}
		// thất bại
		request.setAttribute("songs", songs);
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/song/add.jsp");
		rd.forward(request, response);
	}

}
