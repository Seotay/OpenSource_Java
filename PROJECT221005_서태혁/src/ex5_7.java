class Point3D extends _Point{
	private int z;
	
	public Point3D() { // 기본 생성자
		super(0,0);
		this.z = 0;
	}
	public int getZ() {
		return this.z;
	}
	public Point3D(int x, int y, int z) { // 인자가 있는 생성자
		super(x,y);
		this.z = z;
	}
	public String toString() {
		return ("(" + getX() + "," + getY() + "," + getZ() + ")의 점");
	}
	public void moveUp() {
		this.z++;	
		}
	public void moveDown() {
		this.z--;
	}
	public void move(int x, int y, int z) {
		super.move(x, y);
		this.z = z;
	}
}
public class ex5_7 {

	public static void main(String[] args) {
		Point3D p = new Point3D(1,2,3); // 1, 2, 3은 각각 x, y, z축의 값
		System.out.println(p.toString() + "입니다.");
		
		p.moveUp(); // z 축으로 이동
		System.out.println(p.toString() + "입니다.");
		
		p.moveDown(); // z 축으로 아래쪽으로 이동
		p.move(10, 10); // x, y 축으로 이동
		System.out.println(p.toString() + "입니다.");
		
		p.move(100, 200, 300); // x, y, z 축으로 이동
		System.out.println(p.toString() + "입니다.");
	}

}
