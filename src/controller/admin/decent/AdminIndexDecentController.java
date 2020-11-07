package controller.admin.decent;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DecentralazitionDao;
import dao.RoleDao;
import model.Decentralazition;
import model.Role;

public class AdminIndexDecentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminIndexDecentController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		RoleDao roleDao = new RoleDao();
		List<Role> listRole = roleDao.findAll();
		request.setAttribute("listRole", listRole);

		DecentralazitionDao decentralazitionDao = new DecentralazitionDao();
		List<Decentralazition> listDecentralazition = decentralazitionDao.findAll();
		request.setAttribute("listDecentralazition", listDecentralazition);

		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/decent/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DecentralazitionDao decentralazitionDao = new DecentralazitionDao();
		String src = request.getParameter("asrc");
		int id = Integer.parseInt(request.getParameter("aid"));
		String colName = request.getParameter("aobjRole");
		PrintWriter out = response.getWriter();
		int idx = src.lastIndexOf("/");
		String firstName = src.substring(0, idx + 1);
		String lastName = src.substring(idx + 1);
		String fileName = "";

		if (lastName.equals("tick.png")) {
			fileName = firstName + "cancel.png";
			decentralazitionDao.editDecentralazition(colName, 0, id);
		} else {
			fileName = firstName + "tick.png";
			decentralazitionDao.editDecentralazition(colName, 1, id);
		}
		out.print(fileName);
	}

}
