import java.util.Scanner;

class Player{
	Scanner scanner = new Scanner(System.in);
	
	private String playerName; // 게임참가자 이름
	private String word; //  참가자 입력 단어
	
	public Player(String playerName) {
		this.playerName = playerName;
	}
	
	
	public String getWordFromUser(){ // 사용자로부터 단어를 입력 받는다.
		System.out.print(playName + ">>");
		word = scanner.next();
		return word;
	}
	public boolean checkSuccess(String lastWord, String newWord){ // 끝말잇기의 성공여부와 사용자로부터 단어를 입력 받는다.
		int lastIndex = lastWord.length() -1; // 마지막 문자에 대한 인덱스
		char lastChar = lastWord.charAt(lastIndex); // 마지막 문자 
		char firstChar = newWord.charAt(0); // 첫번째 문자
		
		if(firstChar == lastChar) // 마지막 문자와 첫번째 문자가 일치하면(게임 승리)
			return true;
		else
			return false;
	}
	
	public void getName() {
		System.out.print(playerName); 
	}
	
}

class Main{
	
	
	
}

public class problem_OpenChallenge {
	private Scanner scanner = new Scanner(System.in);
	private String word = "아버지"; // 끝말잇기 제시 단어
	private Player player[]; 
	
	public static void main(String[] args) {
		problem_OpenChallenge WordGameApp = new problem_OpenChallenge();
		WordGameApp.run(); // 게임 실행
	}
	
	public void run() {
		System.out.println("끝말잇기 게임을 시작합니다...");
		System.out.print("게임에 참가하는 인원은 몇명입니까>>");
		
		int n = scanner.nextInt(); // 게임에 참가하는 인원 수
		player = new Player[n]; // 인원 수 만큼 Player 객체배열 생성
		
		for(int i=0; i<n; i++) {
			System.out.print("참가자의 이름을 입력하세요>>");
			String name = scanner.next();
			
			player[i] = new Player(name);
			}
		
		String lastWord = word; // 시작하는 단어 word "아버지"를 lastWord로 초기화
		
		System.out.print("시작하는 단어는 ");
		System.out.println(lastWord + "입니다.");
		
		int i = 0;
		
		while(true) {
			String nextWord = player[i].getWordFromUser(); // 입력받은 새로운 단어가 nextWord
			
			if(player[i].checkSuccess(lastWord, nextWord) == false) {
				player[i].getName();
				System.out.println("이 졌습니다.");
				break;
			}
			i++; // 다음 참가자 차례
			
			if(i == n) // 마지막 참가자일 때
				i = 0; // 다시 첫 번째 참가자 차례
			lastWord = nextWord;
			}
	}
	
	

}
