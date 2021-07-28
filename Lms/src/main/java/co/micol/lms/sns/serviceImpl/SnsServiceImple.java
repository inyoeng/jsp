package co.micol.lms.sns.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.lms.common.DAO;
import co.micol.lms.sns.service.SnsService;
import co.micol.lms.sns.vo.CommentsVO;
import co.micol.lms.sns.vo.SnsVO;

public class SnsServiceImple implements SnsService {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<SnsVO> SnsSelectList() {
		// TODO 글 목록 가져오기
		List<SnsVO> list = new ArrayList<SnsVO>();
		SnsVO vo;
		String sql = "select * from sns";
		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {
				vo = new SnsVO();
				vo.setsNo(rs.getInt("sno"));
				vo.setsWriter(rs.getString("swriter"));
				// vo.setsContent(rs.getString("scontent"));
				vo.setsDate(rs.getDate("sdate"));
				vo.setsTitle(rs.getString("stitle"));
				vo.setsAno(rs.getInt("sano"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<SnsVO> snsSelect(int no) {
		// TODO 선택한 글을 댓글을 포함하여 가져온다.
		List<SnsVO> list = new ArrayList<SnsVO>();
		SnsVO vo;
		String sql = "select a.*, b.cname, b.csubject, b.cdate from sns a left outer join comments b "
				+ "on (a.sno = b.sno) where a.sno = ? ";
		boolean b = false;

		try {
			conn = DAO.getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, no);
			psmt.setInt(2, no);
			rs = psmt.executeQuery();

			while (!b) {
				vo = new SnsVO();

				vo.setsNo(rs.getInt("sno"));
				vo.setsWriter(rs.getString("swriter"));
				vo.setsDate(rs.getDate("sdate"));
				vo.setsTitle(rs.getString("stitle"));
				vo.setsContent(rs.getString("scontent"));
				vo.setsAno(rs.getInt("sano"));
				vo.setcName(rs.getString("cname"));
				vo.setcSubject(rs.getString("csubject"));
				vo.setcDate(rs.getDate("cdate"));

				list.add(vo);
				if (rs.next()) {
					continue;
				} else {
					b = true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	@Override
	public int snsInsert(SnsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int commentsInsert(CommentsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int snsDelete(SnsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int commentsDelete(CommentsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int snsUpdate(SnsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int commentsUpdate(CommentsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
