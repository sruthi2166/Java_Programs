package pack1;
 
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
 
public class TC_Hashmap {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String,String> hm=new HashMap<String,String>();
		
		hm.put("1001","Shivababa");
		hm.put("1002","baba");
		hm.put("1003","Shiva");
		hm.put("1004","Om shanti");
		hm.put("1005","Pure");
		
		System.out.println(hm);
		System.out.println(hm.get("1001"));
		
		System.out.println(hm.values());
		
		Set s1=hm.entrySet();
		
		Iterator i=s1.iterator();
		while(i.hasNext())
		{
			Map.Entry me=(Map.Entry)i.next();
			
			System.out.println(me.getKey()+":"+me.getValue());
			
			
			
			
			
		}
		
		
				
		
 
	}
 
}
 