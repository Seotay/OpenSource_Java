import java.util.*;

public class ex_8 {

	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("** 포인트 관리 프로그램입니다 **");
		
		while(true) {
			System.out.print("이름과 포인트 입력>> ");
			String name = scanner.next();
			
			if(name.equals("그만"))
					break;
			
			int point = scanner.nextInt();
			
			if(hm.get(name) == null)
				hm.put(name, point);
			else
				hm.put(name, hm.get(name)+point);
			
			Set<String> keys = hm.keySet();
			Iterator<String> it = keys.iterator();
			
			while(it.hasNext()) {
				String keyName = it.next();
				Integer sum = hm.get(keyName);
				System.out.print("("+ keyName + "," + sum + ")");
			}
			System.out.println();
	}
		
	System.out.println("프로그램을 종료합니다.");
	scanner.close();
	}
}