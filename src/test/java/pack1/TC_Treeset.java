package pack1;
 
import java.util.TreeSet;
 
public class TC_Treeset {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeSet<String> t1=new TreeSet<String>();
		
		t1.add("One");
		t1.add("Two");
		t1.add("Three");
		t1.add("Four");
		t1.add("Five");
		
		for(String index1:t1)
		{
			System.out.println(index1+"");
		}
 
	}
 
}