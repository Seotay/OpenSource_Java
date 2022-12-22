class Sample{
	public int a; // public 멤버
	private int b; // private 멤버
	int c; // 디폴트 멤버
}
public class AccessEx {

	public static void main(String[] args) {
		Sample aClass = new Sample();
		aClass.a = 10;
	// aClass.b = 10; // b는 private으로 선언이 되었으믐로 AccessEx 클래스에서 접근 불가능
		aClass.c = 10;

	}

}
