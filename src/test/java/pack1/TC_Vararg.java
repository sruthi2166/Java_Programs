package pack1;
 
public class TC_Vararg {
	
	void printdetails(String msg,int...numbers)
	{
		System.out.println(msg);
		for(int i:numbers)
		{
			System.out.println(i);
		}
	}
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TC_Vararg obj=new TC_Vararg();
		obj.printdetails("Hello",500,100,600,800,900);
 
	}
 
}
