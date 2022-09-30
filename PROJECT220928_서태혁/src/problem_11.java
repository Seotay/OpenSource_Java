import java.util.Scanner;

class Add{
	private int a; private int b;
	public void setValue(int a, int b) {
		this.a = a; this.b = b;
		}
	public int calculate() {
		return this.a + this.b;
	}
}

class Sub{
	private int a; private int b;
	public void setValue(int a, int b) {
		this.a = a; this.b = b;
		}
	public int calculate() {
		return this.a - this.b;
	}
}
class Mul{
	private int a; private int b;
	public void setValue(int a, int b) {
		this.a = a; this.b = b;
		}
	public int calculate() {
		return this.a * this.b;
	}
}
class Div{
	private int a; private int b;
	public void setValue(int a, int b) {
		this.a = a; this.b = b;
		}
	public int calculate() {
		return this.a / this.b;
	}
}

public class problem_11 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a, b;
		String c;
		
		System.out.print("두 정수와 연산자를 입력하시오>>");
		a = scanner.nextInt();
		b = scanner.nextInt();
		c = scanner.next();
		
		switch(c) {
		
		case "+":
			Add add = new Add();
			add.setValue(a, b);
			System.out.println(add.calculate());
			break;
		
		case "-":
			Sub sub = new Sub();
			sub.setValue(a, b);
			System.out.println(sub.calculate());
			break;
		
		case "*":
			Mul mul = new Mul();
			mul.setValue(a, b);
			System.out.println(mul.calculate());
			break;
		
		case "/":
			Div div = new Div();
			div.setValue(a, b);
			System.out.println(div.calculate());
			break;
			default:
				System.out.println("연산자 다시 입력");
		}
	}

}
