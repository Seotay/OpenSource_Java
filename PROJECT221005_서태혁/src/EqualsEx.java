class Point_2{
	int x, y;
	public Point_2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public boolean equals(Object obj) {
		Point_2 p = (Point_2)obj;
		if(x == p.x && y == p.y)
			return true;
		else
			return false;
	}
}

public class EqualsEx {
	public static void main(String[] args) {
		Point_2 a = new Point_2(2,3);
		Point_2 b = new Point_2(2,3);
		Point_2 c = new Point_2(3,4);
		
		if(a==b) // false
			System.out.println("a==b");
		if(a.equals(b)) // true
			System.out.println("a is equal to b");
		if(a.equals(c)) // false
			System.out.println("a is equal to b");
	}
}
