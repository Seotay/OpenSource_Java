import java.util.Scanner;
import java.util.Vector;
import java.util.InputMismatchException;
class Word_{
	private String engWord;
	private String korWord;
	
	public Word_(String engWord, String korWord) {
		this.engWord = engWord;
		this.korWord = korWord;
	}
	public String getEngWord() {
		return engWord;
	}
	public String getKorWord() {
		return korWord;
	}
}
class WordQuiz_{
	private String name;
	private Scanner scanner;
	private Vector<Word_> v;
	final int MAX =4;
	int[] question;
	
	public WordQuiz_(){
		name = "명품영어";
		question = new int[MAX];
		v = new Vector<Word_>();
		scanner = new Scanner(System.in);
		
		v.add(new Word_("love", "사랑"));
		v.add(new Word_("painting", "그림"));
		v.add(new Word_("bear", "곰"));
		v.add(new Word_("eye", "눈"));
		v.add(new Word_("society", "사회"));
		v.add(new Word_("human", "인간"));
		v.add(new Word_("picture", "사진"));
		v.add(new Word_("apple", "사과"));
		v.add(new Word_("head", "머리"));
		v.add(new Word_("water", "물"));
		v.add(new Word_("nose", "코"));
		v.add(new Word_("book", "책"));
		v.add(new Word_("pencil", "연필"));
		v.add(new Word_("store", "상점"));
	}
	
	
	public void Run() {
		System.out.println("**** 영어 단어 테스트 프로그램 \"" + name + "\" 입니다. ****");
		
		while(true) {
			System.out.print("단어 테스트:1, 단어 삽입:2. 종료:3 >>");
			int input = scanner.nextInt();
			
			switch(input) {
			case 1: 
				test();
				break;
			case 2:
				insertQuiz();
				break;
			case 3:
				System.out.println("\"" + name + "\" 를 종료합니다.");
				return;
			}
		}
	}
	
	public void test() { // 영어 단어 테스트 메소드
		System.out.println("현재 " + v.size() + "개의 단어가 들어 있습니다. -1을 입력하면 종료합니다.");;
		while(true) {
			randomQuiz(); // 문제 배열 생성
			int answerNum = (int)(Math.random()*question.length);
			int answerIndex = question[answerNum];
			System.out.println(v.get(answerIndex).getEngWord() + "?");
			
			for(int i=0; i< question.length; i++) {
				System.out.print("(" + (i+1) + ")" + v.get(question[i]).getKorWord() + " "); // 보기 출력
				}
			System.out.print("> ");
			int input = 0;
			
			try { // 예외가 발생할 경우
				input = scanner.nextInt();
			}
			catch(InputMismatchException e) { // 정수가 아닌 문자열을 입력하면 예외 발생
				System.out.println("숫자를 입력하세요 !!");
				scanner.next(); // 현재 입력 스트림에 남아 있는 토큰 지우기
				continue;
			}
			if(input == -1) { // -1 입력시 종료.
				System.out.println();
				break;
			}
			else if(input -1 == answerNum)
				System.out.println("Excellent !!"); // 정답
			else 
				System.out.println("No. !!"); // 오답
		}
	}
	public void insertQuiz() { // 단어 삽입
		System.out.println("영어 단어에 그만을 입력하면 입력을 종료합니다.");
		while(true) {
			System.out.print("영어 한글 입력 >> ");
			String engWord = scanner.next(); // 추가할 영어단어 입력
			
			if(engWord.equals("그만")) {
				System.out.println();
				break;
			}
			String korWord = scanner.next(); // 추가할 한글단어 입력
			v.add(new Word_(engWord, korWord)); // 벡터에 추가
		}
	}
	
	
	public void randomQuiz() {
		for(int i=0; i< MAX; i++) {
			question[i] = (int)(Math.random() * v.size());
			for(int j=0; j<i; j++) { // 중복 x
				if(question[i] == question[j]) {
					i--;
					continue;
				}
			}
		}
	}
}
public class ex_12 {

	public static void main(String[] args) {
		WordQuiz_ game = new WordQuiz_();
		game.Run();
	}

}
