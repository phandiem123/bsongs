package controller.admin.decent;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

public class AdminEditDecentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminEditDecentController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idUser = Integer.parseInt(request.getParameter("idUser")) ;
		System.out.println(idUser);
		int idRole = Integer.parseInt(request.getParameter("idRole"));
		User user = new User(idUser, "", "", "", idRole);
		UserDao userDao = new UserDao();
		if(userDao.editUser(idUser, user)>0) {
			response.sendRedirect(request.getContextPath() + "/admin/decent/index?msg=editok");
		}
		
	}

}
