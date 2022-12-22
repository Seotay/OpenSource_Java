import java.util.Scanner;

class Player{
	private String name;
	
	public Player(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public int select() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("철수[가위(1), 바위(2), 보(3), 끝내기(4)]>>");
		
		int player = scanner.nextInt();
		return player;
	}
}

class Computer extends Player{
	public Computer(String name) {
		super(name);
	}
	public int select() {
		return (int)(Math.random()*3 + 1);
	}
}

class Game{
	private String[] game = {"가위", "바위", "보"};
	Player[] player = new Player[2];
	
	public Game() { // 생성자
		player[0] = new Player("철수");
		player[1] = new Computer("컴퓨터");
	}
	
	public void run() {// 게임 실행
		
		int playerNum;
		int computerNum;
		while(true) {
		
			playerNum = player[0].select(); // 철수 가위바위보 선택
		
		if(playerNum < 1 || playerNum > 4)
			System.out.println("잘못 입력하였습니다.");
		else if(playerNum == 4) // 4번 끝내기
			break;
		
		computerNum = player[1].select();
		
		System.out.print(player[0].getName() + "(" + game[playerNum - 1] + ")  :  ");
		System.out.println(player[1].getName() + "(" + game[computerNum - 1] + ")");
		
		if(playerNum == computerNum) // 비긴경우
			System.out.println("비겼습니다.");
		else if((playerNum == 1 && computerNum == 2) || (playerNum == 2 && computerNum == 3) || (playerNum == 3 && computerNum == 1)) // 컴퓨터가 이긴 경우
			System.out.println(player[1].getName() + "가 이겼습니다.");
		else if((playerNum == 1 && computerNum == 3) || (playerNum == 2 && computerNum == 1) || (playerNum == 3 && computerNum == 2)) // 철수가 이긴 경우
			System.out.println(player[0].getName() + "가 이겼습니다.");
		}
	}
}

public class ex6_9 {

	public static void main(String[] args) {
		Game game = new Game();
		game.run();

	}

}
