import java.util.Scanner;
public class problem_4 {

	public static void main(String[] args) {
		
			Scanner scanner = new Scanner(System.in);
			System.out.print("소문자 알파벳 하나를 입력하시오>>");
			
			String s = scanner.next();
			char c = s.charAt(0);
			
			for(char j='a'; j<=c;) {
				for(char i='a'; i<=c; i++) {
					System.out.print(i+ " ");
				}
				System.out.println("");
				c = (char)(c-1);
			}
			scanner.close();
		}

}
