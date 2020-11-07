package controller.admin.rep;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SongsDao;
import model.Songs;

public class AdminRepCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminRepCommentController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath() + "/auth/login");
			return;
		}
		SongsDao songDao = new SongsDao();
		int countPage = songDao.getCount(); 
		
		request.setAttribute("countPage", countPage);
		String page = request.getParameter("page");
		if( page == null ) {
			page ="1";
		}
		int pageIndex = Integer.parseInt(page);
		SongsDao songsDao = new SongsDao();
		List<Songs> listPage = songsDao.getAllSongsInPage(pageIndex);
		request.setAttribute("listPage", listPage);
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/comment/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
