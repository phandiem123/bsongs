package controller.publics;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CatDao;
import dao.ContactDao;
import dao.SongsDao;
import model.Categories;
import model.Contacts;
import model.Songs;
import util.StringUtil;


public class PublicIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicIndexController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
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
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/public/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
