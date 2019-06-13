package kr.hs.sdh.money.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sun.org.apache.regexp.internal.recompile;

import kr.hs.sdh.money.vo.MoneySale;
import kr.hs.sdh.utility.DBConnection;

public class MoneyDAO {

	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	public ArrayList<MoneySale> getMemberList(){
		
		ArrayList<MoneySale> saleList = new ArrayList<MoneySale>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select MONEY_TBL_02.custno, custname, grade, sum(price) saleprice from MONEY_TBL_02, MEMBER_TBL_02 where MONEY_TBL_02.custno = MEMBER_TBL_02.CUSTNO group by MONEY_TBL_02.custno, custname, grade";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				MoneySale vo = new MoneySale();
				vo.setCustno(rs.getInt("custno"));
				vo.setCustname(rs.getString("custname"));
				vo.setGrade(rs.getString("grade"));
				vo.setSumprice(rs.getInt("saleprice"));
				
				saleList.add(vo);
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
		
		return saleList;
	}
}
