import java.util.Scanner;
public class problem_8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수 몇개?");
		int n = scanner.nextInt();
		int array[] = new int[n];
		for(int i=0; i<array.length; i++) {
			array[i] = (int)(Math.random()*100+1);
			
			for(int j=0; j<i; j++) {
				if(array[i]==array[j]) {
					i--;
					break;
				}
			}
		}
		
		for(int i=0; i<array.length; i++) {
			if(i%10 == 0)
				System.out.println();
			System.out.print(array[i]);
			System.out.print('\t');
			}
		scanner.close();
		
	}
}
