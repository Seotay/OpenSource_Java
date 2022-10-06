class Rect_{
	int width;
	int height;
	
	public Rect_(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public boolean equals(Object obj) {
		Rect_ p =(Rect_)obj;
		if(width*height == p.width*p.height)
			return true;
		else
			return false;
	}
}
public class EqualsEx_2{

	public static void main(String[] args) {
		Rect_ a = new Rect_(2,3);
		Rect_ b = new Rect_(3,2);
		Rect_ c = new Rect_(3,4);
		if(a.equals(b))
			System.out.println("a is eqal to b");
		if(a.equals(c))
			System.out.println("a is equal to c");
		if(b.equals(c))
			System.out.println("b is equal to c");

	}

}
