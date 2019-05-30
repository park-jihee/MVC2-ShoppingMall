package kr.hs.sdh.member.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.hs.sdh.member.DAO.MemberDAO;
import kr.hs.sdh.member.vo.MemberVO;

public class MemberListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		
		MemberDAO dao = new MemberDAO();
		memberList = dao.getMemberList();
		
		request.setAttribute("memberList", memberList);
		
		RequestDispatcher view = request.getRequestDispatcher("memverList.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
