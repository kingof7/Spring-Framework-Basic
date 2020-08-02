package myspring.di.xml;

//POJO
public class Hello {
	private String name;
	private Printer printer;
	
	//setter method로 di하기
	
	//setname 쓰고  ctrl+space
	
	//String name을 인자로받기 때문에 xml에서 value로 매핑
	public void setName(String name) {
		this.name = name;
	}
	
	//printer라는 객체로 인자를 받기 떄문에 xml에서 ref로 매핑
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	public String sayHello() {
		return "Hello" + name; // String type
		
	}
	
	public void print() {
		this.printer.print(sayHello());
	}
	
	
	
}
