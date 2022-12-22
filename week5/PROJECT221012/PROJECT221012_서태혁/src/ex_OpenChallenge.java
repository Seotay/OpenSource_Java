import java.util.Scanner;
import java.util.Vector;


class Word{
	private String engWord; // 영어 단어
	private String korWord; // 한글 단어
	
	public Word(String engWord, String korWord) {
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

class WordQuiz{
	private String name;
	final int MAX = 4;
	int[] question;
	private Vector<Word> v;
	private Scanner scanner;
	
	public WordQuiz() {
		name = "명품영어";
		question = new int[MAX];
		scanner = new Scanner(System.in);
		v = new Vector<Word>();
		
		v.add(new Word("love", "사랑"));
		v.add(new Word("painting", "그림"));
		v.add(new Word("bear", "곰"));
		v.add(new Word("eye", "눈"));
		v.add(new Word("society", "사회"));
		v.add(new Word("human", "인간"));
		v.add(new Word("picture", "사진"));
		v.add(new Word("apple", "사과"));
		v.add(new Word("head", "머리"));
		v.add(new Word("water", "물"));
		v.add(new Word("nose", "코"));
		v.add(new Word("book", "책"));
		v.add(new Word("pencil", "연필"));
		v.add(new Word("store", "상점"));
		}
	
	public void randomQuiz(){
		for(int i=0; i<MAX; i++) {
			question[i] = (int)(Math.random() * v.size()); // 0~ 문제의 개수
			for(int j=0; j<i; j++) { // 중복된 값 없애기.
				if(question[i] == question[j]) {
					i--;
					continue;
				}
			}
		}
		
}
	public void run() {
		System.out.println("\"" + name + "\"" + "의 단어 테스르르 시작합니다. -1을 입력하면 종료합니다.");
		System.out.println("현재 " + v.size() + "개의 단어가 들어 있습니다.");
		
		while(true) {
			randomQuiz(); // 랜덤한 값을 가진 문제 배열 생성 메소드 호출
			int answerNum = (int)(Math.random()*question.length); // 0~3 까지 한 값을 저장
			int answerIndex = question[answerNum]; 
			
			System.out.println(v.get(answerIndex).getEngWord() + "?");
			
			for(int i=0; i<question.length; i++) {
				System.out.print("(" + (i+1) + ")" + v.get(question[i]).getKorWord() + " ");
				// 0~3까지 배열에 값을 넣어 인덱스의 보기 출력
			}
			System.out.print(": ");
			
			int input = scanner.nextInt();
			if(input == -1) {
				System.out.println("\"" + name + "\"" + "를 종료합니다...");
				scanner.close();
				break;
			}
			else if(input - 1 == answerNum)
				System.out.println("Excellent !!");
			else
				System.out.println("No. !!");
			
			
		}
	
	}
	
}


public class ex_OpenChallenge {

	public static void main(String[] args) {
		WordQuiz wordQuiz = new WordQuiz();
		wordQuiz.run();
	}

}
