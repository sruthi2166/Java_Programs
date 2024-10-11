package pack1;

public class GettersandSetters {
	
	String name;
	int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GettersandSetters obj = new GettersandSetters();
		obj.setName("Leena");
		System.out.println("Name is:"+obj.getName());
		obj.setAge(25);
		System.out.println("Name is:"+obj.getAge());
		

	}

}
