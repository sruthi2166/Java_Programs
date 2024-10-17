package pack1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TC_Regex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			
		String email = "Sruthikatapally@gmail.com";
			
		Pattern p3 = Pattern.compile("^[a-zA-ZO-9-%+-].*@[a-zA-ZO-9.-]+\\.[a-zA-Z]{2,6}$");
		Matcher m3 = p3.matcher(email);
		if(m3.find())
		{
			System.out.print("FOUND");
		}
			
		else
		{
			System.out.println("not Found");
		}
			

	}

}
