package kr.hs.sdh.member.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.hs.sdh.member.vo.MemberVO;
import kr.hs.sdh.utility.DBConnection;

public class MemberDAO {

	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	// DB에서 내용가져오기
	public MemberVO getMemberVO() {
		
		MemberVO vo = new MemberVO();
		
		return vo;
	}
	
	// DB에서 최종번호 가져오기
	public int getCustno() throws Exception{
		int custno = 0;
		
		conn = DBConnection.getConnection();
		
		String sql = "select max(custno) custno from member_tbl_02";
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			custno = rs.getInt(1);
			custno++;
		}
		
		return custno;
	}
	
	public void addMember(MemberVO vo) throws Exception{
		try {
			
		conn = DBConnection.getConnection();
		String sql = "select nvl(max(custno), 0) + 1 from member_tbl_02";
		stmt = conn.prepareStatement(sql);
		
		int custno = 0;
		rs = stmt.executeQuery();
		if(rs.next()) {
			custno = rs.getInt(1);
		}
		
		sql = "insert into member_tbl_02 values (?, ?, ?, ?, ?, ?, ?)";
		stmt = conn.prepareStatement(sql);

		stmt.setInt(1, vo.getCustno());
		stmt.setString(2, vo.getCustname());
		stmt.setString(3, vo.getPhone());
		stmt.setString(4, vo.getAddress());
		stmt.setDate(5, vo.getJoindate());
		stmt.setString(6, vo.getGrade());
		stmt.setString(7, vo.getCity());
		
		stmt.executeUpdate();
		
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.close(rs, stmt, conn);
			} finally {
			
			}
		}
	}
	
	public ArrayList<MemberVO> getMemberList(){
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		
		try {
			conn = DBConnection.getConnection();
			
			String sql = "select * from member_tbl_02 order by desc";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setJoindate(rs.getDate("joindate"));
				vo.setGrade(rs.getString("grade"));
				vo.setCity(rs.getString("city"));
				
				memberList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.close(rs, stmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return memberList;
	}
}












