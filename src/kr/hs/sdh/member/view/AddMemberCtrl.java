package kr.hs.sdh.member.view;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.hs.sdh.member.DAO.MemberDAO;
import kr.hs.sdh.member.vo.MemberVO;


public class AddMemberCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int custno = Integer.parseInt(request.getParameter("custno"));
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		Date joindate = Date.valueOf(request.getParameter("joindate"));
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		
		MemberVO vo = new MemberVO();
		vo.setCustno(custno);
		vo.setCustname(custname);
		vo.setPhone(phone);
		vo.setAddress(address);
		vo.setJoindate(joindate);
		vo.setGrade(grade);
		vo.setCity(city);
		
		MemberDAO dao = new MemberDAO();
		
		dao.addMember(vo);
		
		response.sendRedirect("inae");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
