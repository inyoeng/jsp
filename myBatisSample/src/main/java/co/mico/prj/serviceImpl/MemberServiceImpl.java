package co.mico.prj.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.mico.prj.common.DAO;
import co.mico.prj.member.service.MemberService;
import co.mico.prj.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService{
	
	//dao 선언하기
	private SqlSession sqlSession = DAO.getInstance().openSession();

	@Override
	public List<MemberVO> memberSelectList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("memberSelectList");
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("memberSelect", vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("memberInsert", vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("memberUpdate", vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("memberDelete", vo);
	}

}
