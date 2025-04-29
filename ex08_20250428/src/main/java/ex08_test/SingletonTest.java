package ex08_test;

public class SingletonTest {
	
	public static void main(String[] agrs) {
		
		A a = A.getInstance(); 
		
		A b = A.getInstance();
		
		System.out.println(a == b );
		System.out.println("==================");
		
		B c = new B();
		B d = new B();
		System.out.println(c == d );
		System.out.println("==================");
		
		
	}
}
