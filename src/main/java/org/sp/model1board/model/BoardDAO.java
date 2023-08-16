package org.sp.model1board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.sp.model1board.domain.Board;

//DB의 board테이블에 대한 crud를 수행하는 객체
//중립적일수록 재사용성 높음
//따라서 javaEE, javaSE 플랫폼을 가리지 않고 사용할 수 있는 객체여야함
public class BoardDAO {
	
	//모든 레코드 가져오기
	public List selectAll() {
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="jsp";
		String pass="1234";
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List list=new ArrayList();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url, user, pass);
			
			String sql="select * from board order by board_idx desc";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery(); //select문 수행 후 표 반환
			
			//rs가 곧 닫힐 예정이므로, rs를 대신할 DTO를 생성하여 옮겨담은 후, 
			//그 DTO를 다시 list에 담기
			while(rs.next()) {
				Board board=new Board(); //빈 DTO생성
				
				board.setBoard_idx(rs.getInt("board_idx"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setRegdate(rs.getString("regdate"));
				board.setContent(rs.getString("content"));
				board.setHit(rs.getInt("hit"));
				
				list.add(board); //리스트에 DTO담기
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		return list;
	}
	
	//레코드 1건 넣기
	public int insert(Board board) {
		int result=0;
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="jsp";
		String pass="1234";
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		//DB에 insert작업
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속
			con=DriverManager.getConnection(url, user, pass);
			
			//쿼리 실행
			String sql="insert into board(board_idx, title, writer, content)";
			sql+=" values(seq_board.nextval, ?, ?, ?)";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			
			result=pstmt.executeUpdate(); //DML수행
			//out.print()는 response객체가 보유한 문자기반 출력스트림에 문자열을 쌓아놓는 것.
			//이렇게 하면 추후 응답 시 이 문자열을 넘겨받은 클라이언트인 웹브라우저가 문자열 내에 들어있는 js를 해석하여, alert()수행 후 재접속 시도

			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
