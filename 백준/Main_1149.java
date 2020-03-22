import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_RGB거리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][]map = new int[N+1][3];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int [][] temp = new int[N+1][3];
		
		for (int i = 0; i < 3; i++) {
			temp[0][i]=0;
		}
		for (int i = 1; i <= N; i++) {
			temp[i][0] = Math.min(temp[i-1][1], temp[i-1][2]) + map[i][0];
			temp[i][1] = Math.min(temp[i-1][0], temp[i-1][2]) + map[i][1];
			temp[i][2] = Math.min(temp[i-1][0], temp[i-1][1]) + map[i][2];
		}
		System.out.println(Math.min(Math.min(temp[N][0], temp[N][1]), temp[N][2]));
	}
}
