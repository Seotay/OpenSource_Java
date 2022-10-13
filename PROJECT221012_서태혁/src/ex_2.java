import java.util.*;

public class ex_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Character> arraylist = new ArrayList<Character>();
		System.out.print("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/F)>>");
		
		for(int i=0; i<6; i++) {
			char n = scanner.next().charAt(0);
			arraylist.add(n); // 6개의 학점을 문자로 입력 받는다
		}
		double sum = 0.0;
		double avg; // 평균
		
		for(int i=0; i<arraylist.size(); i++) {
			
			switch(arraylist.get(i)) {
			case 'A':
				sum += 4.0;
				break;
			case 'B':
				sum += 3.0;
				break;
			case 'C':
				sum += 2.0;
				break;
			case 'D':
				sum += 1.0;
				break;
			case 'F':
				break;
			}
		}
		avg = sum / 6;
		System.out.println(avg);
		
		
		
	}

}
