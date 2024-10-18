package pack1;
 
import java.util.HashSet;
 
public class TC_Hashset {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		HashSet<Integer> s1=new HashSet<Integer>();
		s1.add(100);
		s1.add(1000);
		s1.add(10000);
		s1.add(100);
		s1.add(1000);
		s1.add(10000);
		
		System.out.println("size:"+s1.size());
		for(Integer index:s1)
		{
			System.out.println("index"+"");
		}
		
		HashSet<String> s2=new HashSet<String>();
		s2.add("f");
		s2.add("d");
		s2.add("g");
		s2.add("b");
		s2.add("p");
		s2.add("q");
		
		System.out.println("size:"+s2.size());
		
		for(String index1:s2)
		{
			System.out.println("index1"+"");
		}
 
	}
 
}
 