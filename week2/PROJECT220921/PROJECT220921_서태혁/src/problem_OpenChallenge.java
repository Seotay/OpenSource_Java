import java.util.Scanner;
public class problem_OpenChallenge {
	public static void main (String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	while(true) {
		int n = (int)(Math.random()*100);
		System.out.println("수를 결정하였습니다. 맞추어 보세요.\n0~99");
		for(int i=0;;i++) {
			System.out.print(i + ">>");
			int kard = scanner.nextInt();
			
			if(kard<n)
				System.out.println("더 높게");
			else if(kard>n)
				System.out.println("더 낮게");
			else if(kard==n) {
				System.out.println("맞았습니다.");
				break;
				}
			}
		System.out.print("다시하시겠습니까(y/n)>>");
		String a = scanner.next();
		
		if(a.equals("y"))
			continue;
		else if(a.equals("n")) {
			System.out.println("종료");
			break;
		}
			
		
		}
	scanner.close();
	}
}
