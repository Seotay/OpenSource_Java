import java.util.Scanner;

class Day {
	private String work; // 하루의 할 일을 나타내는 문자열
	
	public void set(String work) {
		this.work = work;
	}
	public String get() {
		return work;
	}
	public void show() {
		if(work == null)
			System.out.println("없습니다.");
		else 
			System.out.println(work + "입니다.");
	}
	
}

class MonthSchedule{
	Scanner scanner = new Scanner(System.in);
	private int d;
	private Day day[];
	
	public MonthSchedule(int d) {
		this.d = d;
		day = new Day[d];
		for(int i=0; i<d; i++) {
			day[i] = new Day();
		}
	}
	
	public void run() {
		System.out.println("이번달 스케쥴 관리 프로그램.");
		
		while(true) {
			System.out.print("할일(입력:1, 보기:2, 끝내기:3) >>");
			
			int n = scanner.nextInt();
			
			if(n == 1)
				input();
			else if(n == 2)
				view();
			else {
				finish();
				break;
			}		
		}
	}
	public void input() {
		System.out.print("날짜(1~30)?");
		int a = scanner.nextInt();
		
		System.out.print("할일(빈칸없이입력)?");
		String b =  scanner.next();
		
		day[a-1].set(b);
		
		System.out.println();
		
	}
	public void view() {
		System.out.print("날짜(1~30)?");
		int c = scanner.nextInt();
		
		System.out.print(c + "일의 할 일은 ");
		day[c-1].show();
		System.out.println();
	}
	public void finish() {
		System.out.println("프로그램을 종료합니다.");
	}
	
}

public class problem_7 {

	public static void main(String[] args) {
		MonthSchedule april = new MonthSchedule(30); // 4월달의 할 일
		april.run();

	}

}
