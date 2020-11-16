package ourbox.db;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class ConnectionPoolServlet extends HttpServlet{
	
	private static final Logger logger = LoggerFactory .getLogger(ConnectionPoolServlet.class);
	@Override
	public void init() throws ServletException {
		logger.debug("connectionPool");
		
		//ConnectionPoolServlet이 초기화 될 때 커넥션 풀을 생성해서
		//application 영역에 저장
		//다른 jsp, servlet에서는 application 영역을 통해 커넥션 풀을 접근

		//커넥션 pool 생성
		BasicDataSource bd = new BasicDataSource();
		bd.setDriverClassName("oracle.jdbc.driver.OracleDriver"); 	//classforName
		bd.setUrl("jdbc:log4jdbc:oracle:thin:@112.220.114.130:1521:xe");		//oracle url
		bd.setUsername("team4_202005"); 	
		bd.setPassword("java");
		bd.setInitialSize(20); 	//커넥션 풀 만들 때 몇개의 커넥션풀로 지정해서 생성할건지

		ServletContext sc = getServletContext();
		sc.setAttribute("bd", bd);
	}
}
