package pack1;
abstract class shape
{
	abstract void draw();

	void paint() {
		// TODO Auto-generated method stub
		System.out.println("Drawing");
	}
	
}
class rect extends shape
{
	

@Override
void draw() {
	// TODO Auto-generated method stub
	System.out.println("Rectangle");
	
}
@Override
void paint() {
	// TODO Auto-generated method stub
	System.out.println("Painted");
	
}
}

public class TC_Abstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


