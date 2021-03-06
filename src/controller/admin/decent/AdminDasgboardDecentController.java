package controller.admin.decent;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RoleDao;
import dao.UserDao;
import model.Role;
import model.User;

public class AdminDasgboardDecentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminDasgboardDecentController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idRole = Integer.parseInt(request.getParameter("idRole"));
		System.out.println(idRole);
		UserDao userDao = new UserDao();
		List<User> listUser = userDao.findByIdRole(idRole);
		
		request.setAttribute("listUser", listUser);
		
		RoleDao  roleDao = new RoleDao();
		List<Role> listRole = roleDao.findAll();
		Role itermRoleForHead = roleDao.findById(idRole);
		request.setAttribute("listRole",listRole );
		request.setAttribute("itermRoleForHead",itermRoleForHead );
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/decent/dashboard.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idUser = Integer.parseInt(request.getParameter("idUser")) ;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		int idRole = Integer.parseInt(request.getParameter("idRole"));
		User user = new User(idUser, username, password, fullname, idRole);
		UserDao userDao = new UserDao();
		if(userDao.editUser(idUser, user)>0) {
			response.sendRedirect(request.getContextPath() + "/admin/decent/index?msg=editok");
		}
	}

}
