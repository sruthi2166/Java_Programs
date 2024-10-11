package pack1;

public class TC002_Switchcase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<=4;i++)
		{
			switch(i)
			{
			case 0:
			System.out.println("i is zero");
			break;
			case 1:
			System.out.println("i is one");
			break;
			case 2:
			System.out.println("i is two");
			break;
			case 3:
			System.out.println("i is three");
			break;
			case 4:
			System.out.println("i is four");
			break;
				
			}
		}
		
		int j;
		j=0;
		while(j<=4)
		{
			System.out.println("j value is"+j);
			j++;
		}
		
		int k;
		k=0;
		do
		{
			System.out.println("k value is"+k);
			k++;
		}while (k<=4);
		
		
		for(int l=6;l>=0;l--)
		{
			System.out.println("l value is"+l);
		}

	}

}
