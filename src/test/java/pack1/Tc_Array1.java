package pack1;
 
public class Tc_Array1 {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String b[]=new String[2];
		
		int a[]=new int[5];
		a[0]=100;
		a[1]=200;
		a[2]=400;
		a[3]=500;
		a[4]=600;
		b[0]="Apple";
		b[1]="Orange";
		System.out.println("array values:"+(a[1]+a[2]));
		
		
		int c[][]=new int[5][5];
		c[0][0]=1000;
		c[0][1]=2000;
		c[0][2]=3000;
		
		System.out.println("array values:"+(c[0][0]+c[0][1]));
		
		
		
 
	}
 
}
 