import java.util.*;


class Location{
	private String name;
	private int lat, lon; // 위도 경도
	
	public static final int CITY_NUM = 4;
	
	Location(String name, int lat, int lon){
		this.name = name;
		this.lat = lat;
		this.lon = lon;
	}
	
	public String getName() {
		return this.name;
	}
	public int getLat() {
		return this.lat;
	}
	public int getLon() {
		return this.lon;
	}
	public void getField() {
		System.out.println(getName() + "\t" + getLat() + "\t" + getLon()+ "\t");
		return;
	}
}

public class ex_6 {
	public static void main(String[] args) {
		
		HashMap<String, Location> hm = new HashMap<String, Location>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("도시, 위도, 경도를 입력하세요.");
		
		for(int i=0; i<Location.CITY_NUM; i++) {
			System.out.print(">>");
			String input = scanner.nextLine();
			
			StringTokenizer st = new StringTokenizer(input, ",");
			
			String name = st.nextToken().trim();
			int lat = Integer.parseInt(st.nextToken().trim());
			int lon = Integer.parseInt(st.nextToken().trim());
			
			Location l = new Location(name, lat, lon);
			hm.put(name, l);
		}
		
		System.out.println("------------------------");
		Set<String> key = hm.keySet();
		Iterator<String> it = key.iterator();
		
		for(int i=0; i<hm.size(); i++) {
			String cityName = it.next();
			Location l = hm.get(cityName);
			l.getField();
		}
		
		System.out.println("------------------------");
		
		while(true) {
			System.out.print("도시 이름 >> ");
			String input = scanner.next();
			
			if(input.equals("그만"))
				break;
			
			Location l = hm.get(input);
			
			if(l == null)
				System.out.println(input + "는 없습니다.");
			else
				l.getField();
		}
		
		
		System.out.println("프로그램을 종료합니다.");
		scanner.close();	
			
	}
}
