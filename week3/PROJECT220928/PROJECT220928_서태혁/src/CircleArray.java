class Circle_ {
	int radius;
	public Circle_(int radius) {
		this.radius = radius;
	}
	public double getArea() {
		return 3.14*radius*radius;
	}
	
}



public class CircleArray {
	public static void main(String[] args) {
		Circle_[] c;
		c = new Circle_[5];
		
		for(int i = 0; i<c.length; i++)
			c[i] = new Circle_(i);
		
		for(int i =0; i<c.length; i++)
			System.out.print((int)(c[i].getArea()) + " ");

	}

}
