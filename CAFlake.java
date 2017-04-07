package CAApp.edu.neu.cyse6200.app;

public class CAFlake {
	public int size;
	public int[][] flake; 
	
	//initiation: if the size is odd number the center of the flake if black, else the 4 center cells is black
	CAFlake(int setSize){
		size = setSize;
		// using +2 to set a empty border to simplify the rule class
		flake = new int[size+2][size+2];
		if(size % 2 == 1)
			flake[size/2+1][size/2+1] = 1;
		if(size % 2 == 0){
			flake[size/2][size/2] = 1;
			flake[size/2][size/2+1] = 1;
			flake[size/2+1][size/2] = 1;
			flake[size/2+1][size/2+1] = 1;
		}
	}
	
	public void printArray(int step){
		System.out.println("STEP: " + step);
		for(int i = 1; i < size+1; i++){
			for (int j = 1; j < size+1; j++){
				if (flake[i][j] == 1) System.out.print("■"+" ");
				else System.out.print("□"+" ");
			}
			System.out.println();
		}
		System.out.println("\n");
	}
}