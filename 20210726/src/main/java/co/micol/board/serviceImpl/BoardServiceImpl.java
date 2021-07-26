package co.micol.board.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.board.dao.DAO;
import co.micol.board.service.BoardService;
import co.micol.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	

	@Override
	public List<BoardVO> boardSelectList() {
		// TODO 게시판 목록 가지고 오기.
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "select * from board order by bid desc";
		BoardVO vo;// vo 객체 생성
		
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new BoardVO();//vo초기화
				vo.setbId(rs.getInt("bid"));
				vo.setbTitle(rs.getString("bTitle"));
				//vo.setbContent(rs.getString("bContent")); //목록 뿌리는데 내용은 필요 없으니가. 
				vo.setbDate(rs.getDate("bDate"));
				vo.setbWriter(rs.getString("bWriter"));
				vo.setbHit(rs.getInt("bHit"));
				
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}

	private void close() {
		// TODO 연결 종료시킨다. (연 순서의 반대로 닫아줌)
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public BoardVO boardSelect(BoardVO vo) {
		// TODO 한 행 조회하기
		
		String sql ="select * from board where bid=?";
		
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new BoardVO();//vo초기화
				vo.setbId(rs.getInt("bid"));
				vo.setbTitle(rs.getString("bTitle"));
				vo.setbContent(rs.getString("bContent")); 
				vo.setbDate(rs.getDate("bDate"));
				vo.setbWriter(rs.getString("bWriter"));
				vo.setbHit(rs.getInt("bHit"));
				
				hitUpdate(vo.getbId()); //조회수 증가 메소드
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return vo;
	}

	private void hitUpdate(int id) {
		// TODO 클릭수 세는 메서드
		String sql = "update board set bhit = bhit+1 where bid=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int boardInsert(BoardVO vo) {
		// TODO 글 추가
		
		String sql = "insert into board(bid, btitle,bcontent, bwriter,bdate) values(b_seq.nextval, ?,?,?,?)";
		int n = 0;
		
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getbTitle());
			psmt.setString(2, vo.getbContent());
			psmt.setString(3, vo.getbWriter());
			psmt.setDate(4, vo.getbDate());
			
			n= psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		// TODO 글 제목과 글 내용 변경한다. 
		String sql ="update board set btitle=?, bcontent=? where bid=?";
		int n =0;
		
		try {
			conn=DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbTitle());
			psmt.setString(2, vo.getbContent());
			psmt.setInt(3, vo.getbId());
			
			n = psmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
	}

	@Override
	public int boardDelete(BoardVO vo) {
		// TODO 한 행 삭제
		String sql ="delete from board where bid=?";
		int n =0;
		
		try {
			conn=DAO.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			
			n = psmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;

	}

}
