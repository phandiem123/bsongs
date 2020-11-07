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
import model.Decentralazition;
import util.ImgeasUtils;

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


		DecentralazitionDao  decentralazitionDao = new DecentralazitionDao();
		List<Decentralazition> listDecentralazition = decentralazitionDao.findAll();
		List<Decentralazition> listDecent = decentralazitionDao.findAll();
		int [][] status = new int [listDecentralazition.size()][9];
		for (Decentralazition objDecentralazition : listDecentralazition) {
			int i =1;
			while(i<=listDecentralazition.size()){
				status[i][1]= objDecentralazition.getAddEvery();
				status[i][2]=objDecentralazition.getEditEvery();
				status[i][3]=objDecentralazition.getDelEvery();
				status[i][4]= objDecentralazition.getAddSelf();
				status[i][5]=objDecentralazition.getEditSelf();
				status[i][6]=objDecentralazition.getDelSelf();
				status[i][7]= objDecentralazition.getAddAnother();
				status[i][8]=objDecentralazition.getEditAnother();
				status[i][9]=objDecentralazition.getDelAnother();
				request.setAttribute("listDecentralazition"+i+"", listDecentralazition);
			}
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/decent/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		DecentralazitionDao  decentralazitionDao=  new DecentralazitionDao();
		String src = request.getParameter("asrc");
		int idNameCol=Integer.parseInt(request.getParameter("aid")) ;
		int idobjRole=Integer.parseInt(request.getParameter("aobjRole")) ;
		String nameCol=ImgeasUtils.ChangeImgeasToNameCol(idNameCol);
		
		PrintWriter out = response.getWriter();
		int idx = src.lastIndexOf("/");
		String firstName = src.substring(0, idx + 1);
		String lastName = src.substring(idx + 1);
		String fileName = "";
		
		if (lastName.equals("tick.png")) {
			fileName = firstName + "cancel.png";
			int editDecentralazition = decentralazitionDao.editDecentralazition(nameCol, 0, idobjRole);
		} else {
			fileName = firstName + "tick.png";
			int editDecentralazition = decentralazitionDao.editDecentralazition(nameCol, 1, idobjRole);
		}
		out.print(fileName);
	}

}
