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

@WebServlet("/Admin")
public class Admin extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecordDAO dao = new RecordDAO();
		List<RecordBook>list= dao.findAll();
		request.setAttribute("list",list);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/main.jsp");
		rd.forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String date = request.getParameter("date");
		String content = request.getParameter("content");
		int price = Integer.parseInt(request.getParameter("price"));
		RecordDAO dao = new RecordDAO();
		dao.insertOne(new RecordBook(date,content,price));
		request.setAttribute("msg", "1件追加しました");
		doGet(request,response);
	}

}
