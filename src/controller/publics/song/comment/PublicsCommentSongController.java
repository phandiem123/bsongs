package controller.publics.song.comment;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;
import model.Comment;

public class PublicsCommentSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicsCommentSongController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		CommentDao commentDao = new CommentDao();
		String name = request.getParameter("name");
		String textComment = request.getParameter("textComment");
		int idSong = Integer.parseInt(request.getParameter("idSong"));
		// tao gio crentime
		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		System.out.println(textComment);
		Comment comment = new Comment(0, name, textComment, ts, idSong);
		int add = commentDao.addComment(comment, idSong);
		if (add > 0) {
			response.sendRedirect(request.getContextPath() + "/detail?idSong="+idSong);
			return;
		}


	}

}
