import java.util.Scanner;
public class problem_6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1}; // 환산할 돈의 종류
		System.out.print("금액을 입력하시오>>");
		int price = scanner.nextInt();
		
		for(int i=0; i<unit.length; i++) {
			System.out.println(unit[i] + "원 짜리 : " + price/unit[i] + "개");
			price = price % unit[i];			
		}
		scanner.close();
	}
}
