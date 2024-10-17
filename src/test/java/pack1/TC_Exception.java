package pack1;

public class TC_Exception {
	public static void main(String[] args) {

try
{
String str = null;
str.equals("Hello");

}
catch(NullPointerException e){
	System.out.println(e.getMessage());
	System.out.println(e.toString());
}
System.out.println("Hello");
System.out.println("Welcome");
try
{
	int a=0;
	int b=30/a;
}
catch(ArithmeticException e1)
{
	System.out.println(e1.getMessage());
	System.out.println(e1.toString());
}

System.out.println("Hello1");
System.out.println("Welcome1");

}
}
