package ExceptionPropagation;

public class ClassC {
static void m() {
	try {
		System.out.println(10/0);
	}catch(ArithmeticException e) {
		System.out.println("/ by 0");
		throw e;
	}
}
}
