package pack1;

public class TC001_Variable {
	
	
	private static double dblwidth;
	private static double dblheight;
	private static double dbldepth;
	private static int boxid;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calvolume();
		
	}
	
	public static double calvolume()
	{
		double doutemp;
		doutemp = dblwidth * dblheight * dbldepth;
		System.out.println(doutemp);
		return doutemp;
		

		
	}

}
