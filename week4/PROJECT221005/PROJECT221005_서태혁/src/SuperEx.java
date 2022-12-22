class Point_ {
	private int x, y; // 한점을 구성하는 x, y좌표
	public Point_() { // 기본 생성자
		this.x = 0;
		this.y = 0;
	}
	public Point_(int x, int y) { // 인자가 있는 생성자
		this.x = x;
		this.y = y;
	}
	public void showPoint() { // 점의 좌표 출력
		System.out.println("(" + x + "," + y + ")");
	}
}

class ColorPoint_ extends Point_ {
	private String color; // 점의 색
	public ColorPoint_(int x, int y, String color) {
		super(x,y); // Point의 생성자 Point(x,y) 호출
		this.color = color;
	}
	public void showColorPoint() { // 컬러 점의 좌표 출력
		System.out.print(color); 
		showPoint(); // Point 클래스의 showPoint() 호출
	}
}


public class SuperEx {

	public static void main(String[] args) {
		ColorPoint_ cp = new ColorPoint_(5, 6, "blue");
		cp.showColorPoint();

	}

}
