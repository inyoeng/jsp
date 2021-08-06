package co.micol.prj.serviceImple;


import org.apache.ibatis.session.SqlSession;

import co.micol.prj.comm.DataSource;
import co.micol.prj.service.UiTestMapper;
import co.micol.prj.service.UiTestService;
import co.micol.prj.uiTest.vo.UiTestVO;


public class UiTestServiceImpl implements UiTestService{

		private SqlSession sqlSession = DataSource.getInstance().openSession();	

		private UiTestMapper map = sqlSession.getMapper(UiTestMapper.class);
	

	
	@Override
	public UiTestVO login(UiTestVO vo) {
	
		return map.login(vo);
	}







}
