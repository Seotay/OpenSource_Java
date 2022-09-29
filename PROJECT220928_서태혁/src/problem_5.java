import java.util.Scanner;

class Circle_3 {
	private double x, y;
	private int radius;
	public Circle_3(double x, double y, int radius) { // x, y, radius 초기화
		this.x = x; this.y = y; this.radius = radius;
	}
	
	public void show() {
		System.out.println("(" + x + ","+ y + ")"+ radius);
	}
	
}

public class problem_5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Circle_3 c[] = new Circle_3[3]; // 3개의 Circle 배열 선언
		
		for(int i = 0; i< c.length; i++) {
			System.out.print("x, y, radius >>");
			double x = scanner.nextDouble(); // x값 읽기
			double y = scanner.nextDouble(); // y값 읽기
			int radius = scanner.nextInt(); // 반지름 읽기
			c[i] = new Circle_3(x,y,radius); // Circle 생성
		}
		
		for(int i = 0; i<c.length; i++) { // 모든 Circle 객체 출력
			c[i].show();
		}
		scanner.close();
	}

}
