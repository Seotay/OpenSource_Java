import java.util.Scanner;

interface Stack {
	int length(); // 현재 스택에 저장된 개수 리턴
	int capacity(); // 스택의 전체 저장 가능한 개수 리턴
	String pop(); // 스택의 톱(top)에 실수 저장
	boolean push(String val);
}
class StringStack implements Stack{
	String[] array;
	int length;
	int capacity;
	
	public StringStack(int num) {
		this.array = new String[num];
		this.length = 0;
		this.capacity = num;
	}
	public int length() {
		return this.length;
	}
	public int capacity() {
		return this.capacity;
	}
	public String pop() { // 스택 팝
		return array[--length];
	}
	public boolean push(String val) { // 스택 푸시
		if(length == capacity) {
			System.out.println("스택이 꽉 차서 푸시 불가!");
			return false;
		}
		else {
			array[length++] = val;
			return true;
		}
			
	}
	public void StackPrint() { // 스택 출력
		System.out.print("스택에 저장된 모든 문자열 팝 : ");
		for(int i = 0; i<length; i++) {
			System.out.print(this.array[i] + " ");
		}
	}
}

public class ex5_9 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("총 스택 저장 공간의 크기 입력 >>");
		int num = scanner.nextInt();
		StringStack stack = new StringStack(num);
		
		while(true) {
			System.out.print("문자열 입력 >>");
			String s = scanner.next(); // 문자열 입력
			
			if(s.equals("그만"))
				break;
			
			stack.push(s);
		}
		stack.StackPrint();		
	}

}
