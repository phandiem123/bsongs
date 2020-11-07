package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CatDao;
import dao.ContactDao;
import dao.SongsDao;
import dao.UserDao;
import model.Categories;
import model.Contacts;
import model.Songs;
import model.User;

public class AdminIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminIndexController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session  = request.getSession();
		
		if(session.getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return;
		}

		CatDao catDao = new CatDao();
		List<Categories> listCat = catDao.findAll();  
		
		request.setAttribute("listCat", listCat);
		
		SongsDao songDao = new SongsDao();
		List<Songs> listSong = songDao.findAll();
		
		request.setAttribute("listSong", listSong);
		
		UserDao userDao = new UserDao();
		List<User> listUser = userDao.findAll();
		
		request.setAttribute("listUser", listUser);
		
		ContactDao contactDao = new ContactDao();
		List<Contacts> lisContact = contactDao.findAll();
		
		request.setAttribute("lisContact", lisContact);
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
