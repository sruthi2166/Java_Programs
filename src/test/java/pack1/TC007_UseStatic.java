package pack1;

public class TC007_UseStatic {

		
	static int num1 = 3;
	static int num2;
	final int a=30;
	static int b=20;
		
	static {
		System.out.println("Static block");
		num2 = num1*4;
			
	}
	static void mymethod(int num3)
	{
		System.out.println("Number1:"+num1);
		System.out.println("Number2:"+num2);
		System.out.println("Number3:"+num3);
	}

	public static void main(String[] args) {
				// TODO Auto-generated method stub	
		final  int a=30;
		mymethod(500);
			
			
	}

	

}
