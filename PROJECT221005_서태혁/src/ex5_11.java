import java.util.Scanner;
abstract class Calc{
	protected int a;
	protected int b;
	
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	abstract int calculate(); // 오버라이딩
}

class Add extends Calc{
	public int calculate() {
		return a + b;
	}
}

class Sub extends Calc{
	public int calculate() {
		return a - b;
	}
}

class Mul extends Calc{
	public int calculate() {
		return a * b;
	}
}

class Div extends Calc{
	public int calculate() {
		return a / b;
	}
}
class Calculator_ {
	int a, b;
	String c;
	public void Run() {
		
		Scanner scanner = new Scanner(System.in);
		
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
			System.out.println("연산자를 다시 입력하시오.");
			}
		}

}
public class ex5_11 {
	public static void main(String[] args) {
			Calculator_ calculator = new Calculator_();
			calculator.Run();
		}
	}


