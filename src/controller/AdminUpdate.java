package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecordDAO;
import model.RecordBook;


@WebServlet("/Admin/Update")
public class AdminUpdate extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id == null) {
			response.sendRedirect("/recordBook/Admin");
			return;
		}
		RecordDAO dao = new RecordDAO();
		RecordBook rb=dao.findOne(Integer.parseInt(id));
		request.setAttribute("rb", rb);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/admin/update.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id=Integer.parseInt(request.getParameter("id"));
		String date=request.getParameter("date");
		String content=request.getParameter("content");
		int price=Integer.parseInt(request.getParameter("price"));

		RecordDAO dao=new RecordDAO();
		dao.updateOne(new RecordBook(id,date,content,price));
		List<RecordBook>list=dao.findAll();
		request.setAttribute("list", list);
		request.setAttribute("msg", "1件更新しました");
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/admin/main.jsp");
		rd.forward(request, response);
		//response.sendRedirect("/recordBook/Admin");
	}

}
