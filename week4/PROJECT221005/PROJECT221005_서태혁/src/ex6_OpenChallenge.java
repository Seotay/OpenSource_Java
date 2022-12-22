import java.util.Scanner;

class Histogram {
	private Scanner sc = new Scanner(System.in);
	private int arrAlpha[];

	int[] countAlpha(String s) {
		arrAlpha = new int[26];	// 알파벳의 개수인 26의 크기를 갖는 알파벳 배열 생성
		String str = s.toUpperCase(); // 매개변수로 받은 텍스트 문자열을 모두 대문자로 바꾼다.
		for (int i = 0; i < str.length(); i++) { // 처음부터 텍스트의 끝까지 반복
			char c = str.charAt(i);	// 'A'의 아스키코드 값 65, 'Z'의 아스키코드 값 90
			if (c >= 65 && c <= 90)	// 대문자 알파벳만 읽기 위해 c가 'A'보다 크거나 같고 'Z'보다 작거나 같음.
				arrAlpha[c - 65]++;
		}
		return arrAlpha;
	}

	String readString() {
		StringBuffer sb = new StringBuffer(); // 스트링버퍼 생성
		while (true) {
			String line = sc.nextLine(); // 라인 읽기
			if (line.length() == 1 && line.charAt(0) == ';') // ';'만 있는 라인이면
				break; 
			sb.append(line); // 스트링버퍼에 추가
		}
		return sb.toString();
	}

	public void run() {
		System.out.println("영문 텍스트를 입력하고 세미콜론을 입력하세요.");
		String s = this.readString();
		int arr[] = this.countAlpha(s);
		System.out.println("히스토그램을 그립니다.");
		for (int i = 0; i < arr.length; i++) {
			System.out.print((char) (i + 65)); // A~Z 출력
			for (int j = 0; j < arr[i]; j++) // 배열에 누적된 값만큼 "-" 출력
				System.out.print("-");
			System.out.println();
		}
	}

}

public class ex6_OpenChallenge {
	public static void main(String[] args) {
		Histogram his = new Histogram();
		his.run();
	}
}