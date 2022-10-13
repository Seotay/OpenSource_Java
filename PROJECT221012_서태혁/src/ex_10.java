import java.util.*;

abstract class _Shape_{ // 추상클래스
	
	private _Shape_ next;
	
	public _Shape_() {
		next = null;
	}
	
	public void setNext(_Shape_ obj) {
		this.next = obj;
	}
	public _Shape_ getNext() {
		return next;
	}
	public abstract void draw(); // 추상 메소드	
}

class _Line extends _Shape_{
	String name = "Line";
	
	public void draw() {
		System.out.println(name);
	}
}

class _Rect extends _Shape_{
	String name = "Rect";
	
	public void draw() {
		System.out.println(name);
	}
}

class _Circle extends _Shape_{
	String name = "Cirle";
	
	public void draw() {
		System.out.println(name);
	}
}

class Editor{
	
	Scanner scanner = new Scanner(System.in);
	Vector<_Shape_> v = new Vector<_Shape_>();
	
	
	public void Insert(int a) {
		_Shape_ s;
		
		switch(a) {
		case 1:
			s = new _Line();
			v.add(s);
			break;
		case 2:
			s = new _Rect();
			v.add(s);
			break;
		case 3:
			s = new _Circle();
			v.add(s);
			break;
		default : System.out.println("잘못된 접근입니다.");
		}
	}
	
	public void Remove(int a) {
			v.remove(a-1);
	}
	
	public void Print() {
		for(int i=0; i<v.size(); i++) {
			_Shape_ s = v.get(i);
			s.draw();
		}
	}
	
	public void Run() {
		
		System.out.println("그래픽 에디터 beauty을 실행합니다.");
		while(true) {
			System.out.print("삽입(1), 삭제(2), 조회(3), 종료(4) >> ");
			int input = scanner.nextInt();
			
			switch(input) {
			
			case 1: 
				System.out.print("Line(1), Rect(2), Circle(3) >> ");
				int n = scanner.nextInt();
				Insert(n);
				break;
				
			case 2:
				System.out.print("삭제할 도형의 위치 >> ");
				int position = scanner.nextInt();
				if(v.size() == 0 || position > v.size()-1) {
					System.out.println("삭제할 수 없습니다.");
				}
				else
					v.remove(position);
					break;
				
			case 3:
				Print();
				break;
			case 4:
				System.out.println("beauty를 종료합니다.");
				scanner.close();
				return;
				
			default : System.out.println("잘못된 입력입니다.");
			
			}
		}
	}
}


public class ex_10 {

	public static void main(String[] args) {
		
		Editor edit = new Editor();
		edit.Run();
		
	}
}
