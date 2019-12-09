package Exception;

public class TestA {
public static void main(String[] args) {
	System.out.println("started");
	Calculator c1=new Calculator();
	c1.divide(10, 0);
	System.out.println("ended");
}
}
