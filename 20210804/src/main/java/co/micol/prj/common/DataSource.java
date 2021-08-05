
package co.micol.prj.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {
	//실제 데이터 소스 객테임. = dao
	
	//singletone
	private static SqlSessionFactory sqlSession;
	
	//생성자 만들기. 밖에서 못만들게
	private DataSource() {}
	
	public static SqlSessionFactory getInstance() {
		
		try {
			String resource = "/mybatis-Config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSession = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return sqlSession;
	}
}
