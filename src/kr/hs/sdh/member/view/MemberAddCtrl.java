package kr.hs.sdh.member.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.hs.sdh.member.DAO.MemberDAO;
import kr.hs.sdh.member.vo.MemberVO;


public class MemberAddCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		int custno = 0;
		
		try {
			custno = dao.getCustno();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		vo.setCustno(custno);
		
		request.setAttribute("custno", vo);
		RequestDispatcher view = request.getRequestDispatcher("memberAdd.jsp");
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
