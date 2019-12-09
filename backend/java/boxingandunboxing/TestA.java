
public class TestA {
public static void main(String[] args) {
	int i1=10;
	Integer i2=new Integer(i1);          //boxing
	int i3=i2.intValue();                //unboxing
	
    double d1=2.5;
    Double d2=new Double(d1);            //boxing
    double d3=d2.doubleValue();          //unboxing
    
System.out.println(i1);
System.out.println(i2);
System.out.println(i3);

System.out.println(d1);
System.out.println(d2);
System.out.println(d3);
}
}
