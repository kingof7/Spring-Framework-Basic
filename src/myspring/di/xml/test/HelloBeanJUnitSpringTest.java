package myspring.di.xml.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/beans.xml")

public class HelloBeanJUnitSpringTest {

	// bean 주입
	@Autowired
	ApplicationContext context;

	@Test @Ignore
	public void test2() {
		// 2. getBean() 호출
		Hello hello = (Hello) context.getBean("hello");

		Hello hello2 = (Hello) context.getBean("hello");

		assertSame(hello, hello2);

		// 스프링 컨테이너는 bean을 싱글톤(두번생성되지 않는다)으로 관리한다는 사실을 알 수 있음

	}

	@Test
	public void test1() {
		
		Hello hello = (Hello) context.getBean("hello2"); //id값

		assertEquals("Hello Spring", hello.sayHello());
		
		hello.print();
		
		assertEquals(3, hello.getNames().size());
		List<String> list = hello.getNames();

		for (String value : list) {
			System.out.println(value);
		}

		// StringPrinter getBean()
		Printer printer = context.getBean("printer", Printer.class);
		assertEquals("Hello Spring", printer.toString());

	}
}
