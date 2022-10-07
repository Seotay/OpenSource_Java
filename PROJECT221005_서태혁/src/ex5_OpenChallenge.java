import java.util.Scanner;

abstract class GameObject{ // 추상 클래스
	protected int distance; // 한 번 이동거리
	protected int x, y; // 현재 위치(화면 맵 상의 위치
	
	public GameObject(int startX, int startY, int distance) { // 초기 위치와 이동 거리 설정
		this.x = startX;
		this.y = startY;
		this.distance = distance;
	}
	public int getX() {return x;}
	public int getY() { return y;}
	public boolean collide(GameObject p) { // 이 객체가 객체 p와 충돌했으면 true 리턴
		if(this.x == p.getX() && this.y == p.getY())
			return true;
		else
			return false;
	}
	protected abstract void move(); // 이동한 후의 새로운 위치로 x, y변경
	protected abstract char getShape(); // 객체의 모양을 나타내는 문자 리턴
}

class Bear extends GameObject{
	
	public Bear(int startX, int startY, int distance){
		super(startX, startY, distance);
	}
	public void move() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("왼쪽(a), 아래(s), 위(d), 오른쪽(f) >>");
		String key = scanner.next(); // 키 입력
		
		Game_.map[x][y]='-';
		
		switch(key) {
		case "a":
			if(y == 0)
				y = 0;
			else
				y -= distance;
			break;
		case "s":
			if(x == 9)
				x = 9;
			else
				x += distance;
			break;
		case "d":
			if(x == 0)
				x = 0;
			else
				x -= distance;
			break;
		case "f":
			if(y == 19)
				y = 19;
			else
				y += distance;
			break;
		default:
			System.out.print("잘못 입력하였습니다.");
			
		}
		Game_.map[x][y] = getShape();
	}
	
	public char getShape() {
		return 'B';
	}
}
class Fish extends GameObject{
	Fish(int startX, int startY, int distance){
		super(startX, startY, distance);
	}
	
	public void move() {	
		int randomNum = (int)(Math.random()*4); // 상, 하, 좌, 우(랜덤 값: 0~3)
		Game_.map[x][y] = '-'; // 현재 좌표 초기화
		
		switch(randomNum) {
		case 0: // 위
			if(x == 0)
				x = 0;
			else
				x -= distance;
			break;
		case 1: // 아래
			if(x == 9)
				x = 9;
			else 
				x += distance;
			break;
		case 2: // 왼쪽
			if(y == 0)
				y = 0;
			else
				y -= distance;
			break;
		case 3: // 오른쪽
			if(y == 19)
				y = 19;
			else
				y+=distance;
			break;
			}
		Game_.map[x][y] = getShape(); // 좌표 갱신
		}
	public char getShape() {
		return '@';
	}
}
class Game_{
	Bear bear;
	Fish fish;
	
	static char[][] map = new char[10][20]; // 10행 20열의 격자판 생성 -> Bear, Fish 사이에서 공유될 수 있도록 static으로 선언
	
	public void set() { // Bear, Fish 초기 설정
		bear = new Bear(0,0,1);
		fish = new Fish(5,5,1);		
	
	for(int i=0; i<map.length; i++)
		for(int j=0; j<map[i].length; j++)
			map[i][j] = '-';
	
	map[bear.x][bear.y] = bear.getShape();
	map[fish.x][fish.y] = fish.getShape();
	}
	
	public void showMap() { // 게임 맵 출력
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public void winBear() { // Bear가 이기는 경우
		map[bear.x][bear.y] = bear.getShape();
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	public void run() { // 실행
		System.out.println("** Bear의 Fish 먹기 게임을 시작합니다.**");
		set(); // 초기 설정
		showMap(); // 맵 출력
		
		int fishCount = 0; // fish가 움직인 횟수(총 5번 중 3번은 제자리, 2번은 랜덤 이동)
		int totalCount = 0; // 총 진행된 게임 횟수
		 
		while(true) {
			for(int i=0; i<5; i++) {
				bear.move();
				int randomNum = (int)(Math.random() * 2);
				// 0이면 fish 이동, 1이면 fish 제자리
				
				if(bear.collide(fish)) {
					winBear();
					System.out.println("Bear Wins!!");
					return;
				}
				if(totalCount == 5) {
					// 총 진행된 턴이 5가 되면 다시 fish가 움직인 횟수와 함께 0으로 초기화
					totalCount = 0;
					fishCount = 0;
				}
				if(randomNum == 0 && fishCount < 2) {
					// fish가 움직인 횟수가 2보다 작고 && 랜던값이 0인 경우(이동)
					fish.move();
					showMap();
					fishCount++;
					totalCount++;
				}
				else if(randomNum == 1 && totalCount >3 && fishCount <2) {
					// fish가 움직인 횟수가 2보다 작고 총 진행된 턴이 3인 경우 랜덤값이 1이지만 이동
					fish.move();
					showMap();
					fishCount++;
					totalCount++;
				}
				else {
					// 그 외의 경우 fish는 제자리, 턴 증가
					showMap();
					totalCount++;
				}
			}
		}
	}
}

public class ex5_OpenChallenge {
	public static void main(String[] args) {
		Game_ game = new Game_();
		game.run();
	}

}
