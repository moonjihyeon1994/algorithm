import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1932 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][]map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j <= i; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = N-2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				int num1 = map[i][j] + map[i+1][j];
				int num2 = map[i][j] + map[i+1][j+1];
				map[i][j] = Math.max(num1, num2);
			}
		}
		System.out.println(map[0][0]);
		
	}
}
