package kr.co.bit.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.co.bit.database.ConnectionManager;
import kr.co.bit.day4.MemberVO;

public class MemberDAO {

		
			
			public ArrayList<MemberVO> selectAll(){
				
				ArrayList<MemberVO> list = null;
				
			
				ConnectionManager mgr = new ConnectionManager();					
				Connection con = mgr.getConnetion();  // DriverManager 메소드 이용해서 db와 connect한다.  
				if(con!=null){
					Statement stmt;
					try {
						stmt = con.createStatement();
						String sql = "select * from departments"; // table 출력 명령
						ResultSet rs = stmt.executeQuery(sql);   //  table 출력 결과물을 받아오겠다.
						while(rs.next()){   //rs.next() : 받아온 결과물을 row 단위로 한줄씩 읽어낸다.
							
							MemberVO vo = new MemberVO();
							
							String temp1 = rs.getString(1);    // 한 줄 안에서 컬럼(속성)별로 변수화 한다.
							String temp2 = rs.getString(2);
							String temp3 = rs.getString(3);
							String temp4 = rs.getString(4);
							System.out.println(temp1+","+temp2+","+temp3+","+temp4);
							
						
						}
						
						mgr.connectClose(con,stmt,rs);
				
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
				}
				return list;
			}
	
}
