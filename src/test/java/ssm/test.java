package ssm;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	
	@Test
	public void testSql() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		DataSource dataSource = ac.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}
}
