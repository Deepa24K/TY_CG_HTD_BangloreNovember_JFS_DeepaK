package customunchecked;

public class DayLimitException extends RuntimeException{
String msg="daily limit exceeds";

public DayLimitException() {
}

public DayLimitException(String msg) {
	super();
	this.msg = msg;
}

@Override
public String getMessage() {
	return msg;
}


}
