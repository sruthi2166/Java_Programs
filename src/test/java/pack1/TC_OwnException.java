package pack1;

import java.io.FileNotFoundException;

public class TC_OwnException {
	void proc()
	{
		try
		{
			throw new FileNotFoundException("From Exception");
		}catch(FileNotFoundException e)
		{
			System.out.println("Caught inside the demo");
			}
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		TC_OwnException obj=new TC_OwnException();
		obj.proc();

	}

}
