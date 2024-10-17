package pack1;

public class TC_Execption1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int res=10/0;
			int[] numbers= {1,2,3};
			System.out.println(numbers[5]);
			String text=null;
			System.out.println("Length of the message:"+text.length());
		}
		catch(ArithmeticException e)
		{
			System.out.println("Arithmetic error:"+e.getMessage());
		}
		
		catch(ArrayIndexOutOfBoundsException e1)
		{
			System.out.println("Arithmetic error:"+e1.getMessage());
		}
		catch(NullPointerException e2)
		{
			System.out.println("Arithmetic error:"+e2.getMessage());
		}
		catch(Exception e3)
		{
			System.out.println("Unexpected error:"+e3.getMessage());
		}
		finally
		{
			System.out.println("This is the finally block");
		}
		}

	}


