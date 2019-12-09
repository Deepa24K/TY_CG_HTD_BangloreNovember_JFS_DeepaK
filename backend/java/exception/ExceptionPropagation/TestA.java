package ExceptionPropagation;

public class TestA {
public static void main(String[] args) {
	System.out.println("main started");
	ClassA.o();
	System.out.println("main ended");
}
}
