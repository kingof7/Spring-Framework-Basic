package myspring.di.xml;

//Hello와 해당 클래스는 직접적으로 의존관계 x --> xml로 설정해야됨
public class StringPrinter implements Printer{
	
	private StringBuffer buffer = new StringBuffer();
	
	//interface method overriding 필요
	@Override
	public void print(String message) {
		buffer.append(message);
	}
	
	public String toString() {
		return buffer.toString();
	}
	
}
