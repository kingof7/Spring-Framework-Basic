package myspring.di.xml.test;

import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans.xml")
public class HelloBeanJUnitSpringTest {
	
	//bean 주입
	@Autowired
	ApplicationContext context;	
	
	@Test
	public void test() {
		//2. getBean() 호출
		Hello hello = (Hello)context.getBean("hello");
		
		Hello hello2 = (Hello)context.getBean("hello");			
		
		//hello와 hello2의 레퍼(주소)런스가 같은지 확인
		assertSame(hello, hello2); // == true
		
		//스프링 컨테이너는 bean을 싱글톤(두번생성되지 않는다)으로 관리한다는 사실을 알 수 있음
		
	}
		
}
