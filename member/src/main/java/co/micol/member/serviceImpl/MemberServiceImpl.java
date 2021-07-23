package co.micol.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.member.command.DAO;
import co.micol.member.service.MemberService;
import co.micol.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

	//DB작업
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	
	@Override
	public List<MemberVO> memberSelectList() {
		//전체 회원목록 조회
		List<MemberVO> members = new ArrayList<MemberVO>();
		MemberVO vo;//한 명의 데이터를 담을 수 있도록
		String sql ="select * from member";
		try {
			conn =DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); //select 구분일때 무조건 이렇게 만듦. 
			
			while(rs.next()) {
				vo = new MemberVO(); //초기화
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setHobby(rs.getString("hobby"));
				members.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return members;
	}

	//작업 끝나면 connection끊기 위해서
	private void close() {
		//순서는 열린 순서 반대
		try {
	
			if(rs != null) {//열려있다면
				rs.close();
			}if(psmt != null) {
				psmt.close();
			}if(conn != null){
				conn.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		//id로 한 명 조회 여긴 vo가 들어와있네~
		String sql ="select * from member where id= ? ";
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			rs= psmt.executeQuery();
			
			if(rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				vo.setAge(rs.getInt("age"));
				vo.setHobby(rs.getString("hobbys"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		int n =0;
		String sql ="insert into member values(?,?,?,?,?)";
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			psmt.setString(3, vo.getName());
			psmt.setInt(4, vo.getAge());
			psmt.setString(5, vo.getHobby());
			
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		int n =0;
		String sql ="delete from member where id=?";
		
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			
			n = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// TODO 회원정보 변겅
		int n =0;
		String sql ="update member set password=?, age=?, hobby=? where id=? ";
		
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getPassword());
			psmt.setInt(2, vo.getAge());
			psmt.setString(3, vo.getHobby());
			psmt.setString(4, vo.getId());
			
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
	}

}
