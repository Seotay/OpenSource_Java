
public class Circle {
	int radius; // 원의 반지름
	String name; // 원의 이름
	
	public Circle() {} // 원 생성자
	
	public double getArea() { // 원의 면적 계산
		return 3.14*radius*radius;
	}
	
	public static void main(String[] args) {
		Circle pizza;
		pizza = new Circle();
		pizza.radius  = 10;
		pizza.name = "자바피자";
		double area = pizza.getArea();
		System.out.println(pizza.name + "의 면적은 "+ area);
		
		Circle donut = new Circle();
		donut.radius = 2;
		donut.name ="자바도넛";
		area = donut.getArea();
		System.out.println(donut.name + "의 면적은 "+ area);
	}

}
