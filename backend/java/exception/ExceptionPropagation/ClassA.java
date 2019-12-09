package ExceptionPropagation;

public class ClassA {
static void o() {
	try{
		ClassB.n();
	}catch(ArithmeticException e) {
		System.out.println(e.getMessage());
	}
}
}
