package Exception;

public class GoogleMap {
void findLocation(String a) {
	try {
		System.out.println(a.length());
	}catch(NullPointerException n) {
		System.out.println("plz fill loc name");
		throw n;
	}
}
}
