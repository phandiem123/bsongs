package controller.publics;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CommentDao;
import dao.SongsDao;
import model.Comment;
import model.Songs;

public class PublicDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicDetailController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		int idSong = Integer.parseInt(request.getParameter("idSong"));
		SongsDao songsDao = new SongsDao();

		// tăng lượt view
		HttpSession session = request.getSession();
		String hasVisited = (String) session.getAttribute("hasVisited: " + idSong);
		if (hasVisited == null) {
			session.setAttribute("hasVisited: " + idSong, "yes");
			session.setMaxInactiveInterval(1);
			// increse page view
			songsDao.editCountSong(idSong);
		}
		Songs itermSong = songsDao.findByIdSong(idSong);
		request.setAttribute("itermSong", itermSong);

		CommentDao commentDao = new CommentDao();
		List<Comment> lisComments = commentDao.findAllCommentByIdSong(idSong);
		// System.out.println(lisComments.size());

		request.setAttribute("lisComments", lisComments);

		List<Songs> listConnectSong = songsDao.getConnectSongs(idSong, itermSong.getCat().getId());
		request.setAttribute("listConnectSong", listConnectSong);
		RequestDispatcher rd = request.getRequestDispatcher("/view/public/detail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
