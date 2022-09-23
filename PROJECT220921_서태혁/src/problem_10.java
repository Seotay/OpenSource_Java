
public class problem_10 {

	public static void main(String[] args) {
		int matrix[][] = new int[4][4];
		while(true) {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				matrix[i][j] = (int)(Math.random()*10+1);
			}
		}
		
	
		int count = 0;
			for(int k=0; k<=6; k++) {
			int row = (int)(Math.random()*3);
			int col = (int)(Math.random()*3);
			matrix[row][col] = 0;
			}		
			
			for(int i=0; i<matrix.length; i++)
				for(int j=0; j<matrix[i].length; j++) {
					if(matrix[i][j]==0)
						count++;
					}
			if(count == 6)
				break;
	}
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
				System.out.print("\t");
				}
			System.out.println();
			}
		}
}
