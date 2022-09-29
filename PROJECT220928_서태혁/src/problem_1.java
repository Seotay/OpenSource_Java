class TV {
	private String name;
	private int year;
	private int size;
	
	public TV(String name, int year, int size ) {
		this.name = name;
		this.year = year;
		this.size = size;
	}
	public void show() {
		System.out.println(this.name + "에서 만든 " + year + "년형 " + size +"인치 TV");
	}
	
}


public class problem_1 {

	public static void main(String[] args) {
		
		TV myTV = new TV("LG", 2017, 32); // LG에서 만든 2017년 32인치
		myTV.show();
	}

}
