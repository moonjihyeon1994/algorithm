import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17406 {
	private static int[] list;
	private static List<int[]> commands;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] com = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 3; j++) {
				com[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		list = new int[K];
		for (int i = 0; i < list.length; i++) {
			list[i] = i;
		}
		commands = new ArrayList<int[]>();
		com(0,list.length);
		
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < commands.size(); i++) {
			
			// 맵복사
			int[][] arr =  new int[N][M];
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					arr[j][j2] = map[j][j2];
				}
			}
			
			int[]command = commands.get(i);
			for (int j = 0; j < command.length; j++) {
				int num = command[j];
				int r = com[num][0]-1;
				int c = com[num][1]-1;
				int s = com[num][2];
				
				//돌리자
				for (int l = 1; l <= s; l++) {
					int temp = arr[r-l][c-l];
					for (int o = r-l; o < r+l; o++) {
						arr[o][c-l] = arr[o+1][c-l];
					}
					for (int o = c-l; o < c+l; o++) {
						arr[r+l][o] = arr[r+l][o+1];
					}
					for (int o = r+l; o > r-l; o--) {
						arr[o][c+l] = arr[o-1][c+l];
					}
					for (int o = c+l; o > c-l; o--) {
						arr[r-l][o] = arr[r-l][o-1]; 
					}
					arr[r-l][c-l+1] = temp;
				}
			}
			for (int j = 0; j < N; j++) {
				int num = 0;
				for (int j2 = 0; j2 < M; j2++) {
					num += arr[j][j2];
				}
				if(min>num) min = num;
			}
		}
		System.out.println(min);
	}

	private static void com(int idx, int len) {
		if(idx == len) {
			int [] arr = list.clone();
			commands.add(arr);
		}else {
			for (int i = idx; i < list.length; i++) {
				int temp = list[idx];
				list[idx] = list[i];
				list[i] = temp;
				com(idx+1, len);
				temp = list[idx];
				list[idx] = list[i];
				list[i] = temp;
			}
		}
		
	}
}
