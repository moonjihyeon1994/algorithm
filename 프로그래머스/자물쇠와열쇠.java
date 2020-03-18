import java.util.Arrays;

public class 자물쇠와열쇠 {
	public boolean solution(int[][] key, int[][] lock) {
		int[][] map = new int[lock.length * 3][lock.length * 3];
		
		for (int i = 0; i < lock.length; i++) {
			for (int j = 0; j < lock.length; j++) {
				map[lock.length+i][lock.length+j] = lock[i][j];
			}
		}

		for (int i = 0; i < 4; i++) {
			key = turn(key);

			for (int j = 0; j < map.length - key.length; j++) {
				next: for (int k = 0; k < map.length - key.length; k++) {
					int[][] temp = new int[lock.length * 3][lock.length * 3];

					for (int l = 0; l < map.length; l++) {
						for (int l2 = 0; l2 < temp.length; l2++) {
							temp[l][l2] = map[l][l2];
						}
					}

					for (int l = 0; l < key.length; l++) {
						for (int l2 = 0; l2 < key.length; l2++) {
							if(key[l][l2] == 1) {
								if(temp[j + l][k + l2] == 0) {
									temp[j + l][k + l2] = 1;
								}else {
									continue next;
								}
							}
						}
					}
					
					for (int l = 0; l < lock.length; l++) {
						for (int l2 = 0; l2 < lock.length; l2++) {
							if(temp[lock.length+l][lock.length+l2]==0) continue next;
						}
					}
					
					return true;
				}
			}

		}

		return false;
	}

	private int[][] turn(int[][] key) {
		int[][] temp = new int[key.length][key.length];

		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				temp[j][key.length - i - 1] = key[i][j];
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		자물쇠와열쇠 s = new 자물쇠와열쇠();
		System.out.println(s.solution(new int[][] { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } },
				new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } }));
	}
}
