import java.util.Scanner;

public class problem_16 {

	public static void main(String[] args) {
		String str[] = {"가위", "바위", "보"};
		Scanner scanner = new Scanner(System.in);
		while(true) {
			
			System.out.println("가위바위보 게임을 시작합니다.");
			System.out.print("가위 바위 보!>>");
			String user = scanner.next();
			
			int n = (int)(Math.random()*3);
			
			if(str[n].equals("바위")) {
				if(user.equals("가위"))
					System.out.println("사용자 = 가위, 컴퓨터 = 바위, 졌습니다.");
				else if(user.equals("바위"))
					System.out.println("사용자 = 바위, 컴퓨터 = 바위, 비겼습니다.");
				else if(user.equals("보"))
					System.out.println("사용자 = 보, 컴퓨터 = 바위, 이겼습니다.");
			}
			else if(str[n].equals("가위")) {
				if(user.equals("가위"))
					System.out.println("사용자 = 가위, 컴퓨터 = 가위, 비겼습니다.");
				else if(user.equals("바위"))
					System.out.println("사용자 = 바위, 컴퓨터 = 가위, 이겼습니다.");
				else if(user.equals("보"))
					System.out.println("사용자 = 보, 컴퓨터 = 가위, 졌습니다.");
			}
			else if(str[n].equals("보")) {
				if(user.equals("가위"))
					System.out.println("사용자 = 가위, 컴퓨터 = 보, 이겼습니다.");
				else if(user.equals("바위"))
					System.out.println("사용자 = 바위, 컴퓨터 = 보, 졌습니다.");
				else if(user.equals("보"))
					System.out.println("사용자 = 보, 컴퓨터 = 보, 비겼습니다.");
			}
			if(user.equals("그만")) {
				System.out.println("게임을 종료합니다...");
				break;
			}
		}
		scanner.close();

	}

}
