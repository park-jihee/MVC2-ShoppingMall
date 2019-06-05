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

public class MemberUpdateCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int custno = Integer.parseInt(request.getParameter("custno"));
		
		MemberVO vo = new MemberVO();
		MemberVO member = new MemberVO();
		vo.setCustno(custno);
		try {			
			MemberDAO dao = new MemberDAO();
			dao.getMemberVO(vo);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("member", member);
		
		RequestDispatcher view = request.getRequestDispatcher("memberUpdateCtrl");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
