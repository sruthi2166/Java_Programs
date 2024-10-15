package pack1;

public class PositiveStringchecker {
	 
	
	static boolean isPositiveString(String s)
	{
		int n= s.length();
		char c[] = new char[n];
		for(int i =0; i<n; i++)
		{
				c[i] = s.charAt(i);
			}
		for(int i =0; i<n; i++)
			if(c[i] != s.charAt(i))
				return false;
		return true;
		
	}
		public static void main(String[] args) {
			String s = "ANT";
			
			if(isPositiveString(s))
				System.out.println("Yes");
			else
				System.out.println("NO");
				
		}
		
		
}
