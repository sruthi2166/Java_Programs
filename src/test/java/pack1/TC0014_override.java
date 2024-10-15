package pack1;
class parent
{
	void tv()
	{
		System.out.println("This is parent tv");
		}
}
class child extends parent
{
	void tv()
	{
		System.out.println("This is child tv");
	}
}


public class TC0014_override {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		child obj=new child();
		obj.tv();

	}

}
