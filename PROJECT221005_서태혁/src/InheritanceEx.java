class Person{
	private int weight; // private 멤버
	int age; // 디폴트 멤버
	protected int height; // protected 멤버
	public String name; // public 멤버
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getWeight() {
		return weight;
	}
}

class Student extends Person{
	public void set() {
		age = 30; // 슈퍼클래스의 디폴트 멤버 접근 가능
		name = "홍길동"; // 슈퍼클래스의 public 멤버 접근 가능
		// weight = 99; // 오류. 슈퍼 클래스의 private 접근 불가
		setWeight(99); // private 멤버 weight은 setWeight()으로 간접 접근
	}
}

public class InheritanceEx {
	public static void main(String[] args) {
		Student s = new Student();
		s.set();
	}

}
