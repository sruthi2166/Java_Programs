package pack1;
 
import java.util.ArrayList;
 
public class TC_ArrayList {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> l1=new ArrayList<String>();
		l1.add("Hello");
		l1.add("world");
		l1.add("Apple");
		l1.add("orange");
		
		System.out.println("Size:"+l1.size());
		System.out.println(l1.contains("Hello"));
		System.out.println(l1.get(2));
		System.out.println(l1.remove(3));
		System.out.println("Size:"+l1.size());
		System.out.println("Size:"+l1);
		System.out.println(l1.removeAll(l1));
		System.out.println("Size:"+l1.size());
		System.out.println("Size:"+l1);
		
		
	}
		
}