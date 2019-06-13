package kr.hs.sdh.money.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.hs.sdh.money.dao.MoneyDAO;
import kr.hs.sdh.money.vo.MoneySale;


public class MemberSaleCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MoneySale> saleList = new ArrayList<MoneySale>();
		
		MoneyDAO dao = new MoneyDAO();
		saleList = dao.getMemberList();
		
		request.setAttribute("saleList", saleList);
		
		RequestDispatcher view = request.getRequestDispatcher("memberSale.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
