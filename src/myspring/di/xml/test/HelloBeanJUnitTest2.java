package myspring.di.xml.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="config/beans.xml")
public class HelloBeanJUnitTest2 {

	// bean 주입
	@Autowired
	ApplicationContext context;

	@Test
	public void test() {
		// 2. getBean() 호출
		Hello hello = (Hello) context.getBean("hello");

		Hello hello2 = (Hello) context.getBean("hello");

		// hello와 hello2의 레퍼(주소)런스가 같은지 확인
		assertSame(hello, hello2); // == true

		// 스프링 컨테이너는 bean을 싱글톤(두번생성되지 않는다)으로 관리한다는 사실을 알 수 있음

	}

	// @test 뒤에 @Ignore를 붙이면 해당 테스트 메서드는 실행되지 않음
	@Test @Ignore
	public void test1() {

		// 2. getBean() 호출
		Hello hello = (Hello) context.getBean("hello");

		// assertEquals 메서드는 스태틱 메서드 이기떄문에, 앞에 클래스 Assert.를 항상 붙여줌
		// 그러나 import static org.junit.Assert.assertEquals; 를 선언한다면, 아래처럼 메서드만 사용가능
		assertEquals("HelloSpring", hello.sayHello());
		// 3. Hello의 printer() 호출
		hello.print();

		// StringPrinter getBean()
		Printer printer = context.getBean("printer", Printer.class);
		assertEquals("HelloSpring", printer.toString());
		// System.out.println(hello == hello2); // ref비교, 같다.(싱글톤이니까)

	}

}
