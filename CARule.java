package CAApp.edu.neu.cyse6200.app;

public class CARule {
	public int[][] rule(int[][] a, int size) {
		int[][] temp = new int[size + 2][size + 2];
		for (int i = 0; i < size + 2; i++)
			for (int j = 0; j < size + 2; j++)
				temp[i][j] = a[i][j];

		for (int i = 1; i < size + 1; i++) {
			for (int j = 1; j < size + 1; j++) {
				if (a[i][j] == 0) {
					// 0
					// 1
					if (temp[i - 1][j] == 1 && temp[i + 1][j] == 0 && temp[i][j - 1] == 0 && temp[i][j + 1] == 0)
						a[i][j] = 1;
					if (temp[i - 1][j] == 0 && temp[i + 1][j] == 1 && temp[i][j - 1] == 0 && temp[i][j + 1] == 0)
						a[i][j] = 1;
					if (temp[i - 1][j] == 0 && temp[i + 1][j] == 0 && temp[i][j - 1] == 1 && temp[i][j + 1] == 0)
						a[i][j] = 1;
					if (temp[i - 1][j] == 0 && temp[i + 1][j] == 0 && temp[i][j - 1] == 0 && temp[i][j + 1] == 1)
						a[i][j] = 1;
					// 2
					// 3
					if (temp[i - 1][j] == 1 && temp[i + 1][j] == 1 && temp[i][j - 1] == 1 && temp[i][j + 1] == 0)
						a[i][j] = 1;
					if (temp[i - 1][j] == 0 && temp[i + 1][j] == 1 && temp[i][j - 1] == 1 && temp[i][j + 1] == 1)
						a[i][j] = 1;
					if (temp[i - 1][j] == 1 && temp[i + 1][j] == 0 && temp[i][j - 1] == 1 && temp[i][j + 1] == 1)
						a[i][j] = 1;
					if (temp[i - 1][j] == 1 && temp[i + 1][j] == 1 && temp[i][j - 1] == 0 && temp[i][j + 1] == 1)
						a[i][j] = 1;
					// 4
				}
				// }
			}
		}
		return a;
	}
	public int[][] ruleHex(int[][] a, int size) {
		int[][] temp = new int[size + 2][size + 2];
		for (int i = 0; i < size + 2; i++)
			for (int j = 0; j < size + 2; j++)
				temp[i][j] = a[i][j];

		for (int i = 1; i < size + 1; i++) {
			for (int j = 1; j < size + 1; j++) {
				if (a[i][j] == 0) {
					if (i % 2 != 0){
						if (temp[i-1][j-1] == 1 && temp[i-1][j] == 0 && temp[i][j-1] == 0 && temp[i][j+1] == 0 && temp[i+1][j-1] == 0 && temp[i+1][j] == 0) a[i][j] = 1;
						if (temp[i-1][j-1] == 0 && temp[i-1][j] == 1 && temp[i][j-1] == 0 && temp[i][j+1] == 0 && temp[i+1][j-1] == 0 && temp[i+1][j] == 0) a[i][j] = 1;
						if (temp[i-1][j-1] == 0 && temp[i-1][j] == 0 && temp[i][j-1] == 1 && temp[i][j+1] == 0 && temp[i+1][j-1] == 0 && temp[i+1][j] == 0) a[i][j] = 1;
						if (temp[i-1][j-1] == 0 && temp[i-1][j] == 0 && temp[i][j-1] == 0 && temp[i][j+1] == 1 && temp[i+1][j-1] == 0 && temp[i+1][j] == 0) a[i][j] = 1;
						if (temp[i-1][j-1] == 0 && temp[i-1][j] == 0 && temp[i][j-1] == 0 && temp[i][j+1] == 0 && temp[i+1][j-1] == 1 && temp[i+1][j] == 0) a[i][j] = 1;
						if (temp[i-1][j-1] == 0 && temp[i-1][j] == 0 && temp[i][j-1] == 0 && temp[i][j+1] == 0 && temp[i+1][j-1] == 0 && temp[i+1][j] == 1) a[i][j] = 1;
					}
					else{
						if (temp[i-1][j+1] == 1 && temp[i-1][j] == 0 && temp[i][j-1] == 0 && temp[i][j+1] == 0 && temp[i+1][j+1] == 0 && temp[i+1][j] == 0) a[i][j] = 1;
						if (temp[i-1][j+1] == 0 && temp[i-1][j] == 1 && temp[i][j-1] == 0 && temp[i][j+1] == 0 && temp[i+1][j+1] == 0 && temp[i+1][j] == 0) a[i][j] = 1;
						if (temp[i-1][j+1] == 0 && temp[i-1][j] == 0 && temp[i][j-1] == 1 && temp[i][j+1] == 0 && temp[i+1][j+1] == 0 && temp[i+1][j] == 0) a[i][j] = 1;
						if (temp[i-1][j+1] == 0 && temp[i-1][j] == 0 && temp[i][j-1] == 0 && temp[i][j+1] == 1 && temp[i+1][j+1] == 0 && temp[i+1][j] == 0) a[i][j] = 1;
						if (temp[i-1][j+1] == 0 && temp[i-1][j] == 0 && temp[i][j-1] == 0 && temp[i][j+1] == 0 && temp[i+1][j+1] == 1 && temp[i+1][j] == 0) a[i][j] = 1;
						if (temp[i-1][j+1] == 0 && temp[i-1][j] == 0 && temp[i][j-1] == 0 && temp[i][j+1] == 0 && temp[i+1][j+1] == 0 && temp[i+1][j] == 1) a[i][j] = 1;
					}
						
				}
				// }
			}
		}
		return a;
	}
	public int[][] ruleSimpleHex(int[][] a, int size) {
		int[][] temp = new int[size + 2][size + 2];
		for (int i = 0; i < size + 2; i++)
			for (int j = 0; j < size + 2; j++)
				temp[i][j] = a[i][j];

		for (int i = 1; i < size + 1; i++) {
			for (int j = 1; j < size + 1; j++) {
				if (a[i][j] == 0) {
					
					if (i % 2 != 0){
						if (temp[i-1][j-1] == 1) a[i][j] = 1;
						else if (temp[i-1][j] == 1) a[i][j] = 1;
						else if	(temp[i][j-1] == 1) a[i][j] = 1;
						else if (temp[i][j+1] == 1) a[i][j] = 1;
						else if (temp[i+1][j-1] == 1) a[i][j] = 1;
						else if(temp[i+1][j] == 1) a[i][j] = 1;
						
					}
					else{
						if (temp[i-1][j+1] == 1) a[i][j] = 1;
						else if (temp[i-1][j] == 1) a[i][j] = 1;
						else if (temp[i][j-1] == 1) a[i][j] = 1;
						else if (temp[i][j+1] == 1) a[i][j] = 1;
						else if (temp[i+1][j+1] == 1) a[i][j] = 1;
						else if (temp[i+1][j] == 1) a[i][j] = 1;
						}
						
				}
				// }
			}
		}
		return a;
	}
}
