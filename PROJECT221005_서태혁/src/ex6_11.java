import java.util.Scanner;

public class ex6_11 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print(">>");
		String s = scanner.nextLine();
		
		StringBuffer sb = new StringBuffer(s);
		
		while(true) {
			System.out.print("명령: ");
			String command = scanner.nextLine();
			
			if(command.equals("그만")) {
				System.out.println("종료합니다");
				break;
			}
			
			String[] tokens = command.split("!");
			if(tokens.length != 2)
				System.out.println("잘못된 명령입니다!");
			else {
			if(tokens[0].length() == 0 || tokens[1].length() == 0) {
				System.out.println("잘못된 명령입니다!");
				continue;
			}
			
			int index = sb.indexOf(tokens[0]);
			if(index == -1) {
				System.out.println("찾을 수 없습니다.");
				continue;
			}
			
			sb.replace(index, index + tokens[0].length(), tokens[1]);
			System.out.println(sb.toString());
			}
		}
 
	}

}
