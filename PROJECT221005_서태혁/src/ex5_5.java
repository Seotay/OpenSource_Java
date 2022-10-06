class _Point{
	private int x, y;
	public _Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	protected void move(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
class _ColorPoint extends _Point{
	private String color;
	
	public _ColorPoint(int x, int y, String color) { // 생성자
		super(x,y);
		this.color = color;
	}
	public void setXY(int x, int y) {
		super.move(x, y);
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String toString() {
		return (this.color + "색의 (" + getX() + "," + getY() + ")의 점");
	}
}

public class ex5_5 {

	public static void main(String[] args) {
		_ColorPoint cp = new _ColorPoint(5,5, "Yello");
		cp.setXY(10, 20);
		cp.setColor("RED");
		
		String str = cp.toString();
		System.out.println(str + "입니다.");
	}
}
