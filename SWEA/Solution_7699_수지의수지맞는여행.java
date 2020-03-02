import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7699_수지의수지맞는여행 {
	
	static int[][]dirs = {{1,0},{0,1},{-1,0},{0,-1}};
	private static int max,R,C;
	private static boolean[] visited;
	private static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int testcase = 1; testcase <= tc; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map =  new int[R][C];
			for (int i = 0; i < R; i++) {
				String str = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = str.charAt(j)-65;
				}
			}
			
			max = Integer.MIN_VALUE;
			visited = new boolean[26];
			visited[map[0][0]] = true;
			go(0,0,1);
			sb.append('#').append(testcase).append(' ').append(max).append('\n');
		}
		System.out.println(sb);
	}

	private static void go(int x, int y, int count) {
		if(max==26) return;
		if(max<count) max = count;
		
		for (int i = 0; i < 4; i++) {
			int dx = x + dirs[i][0];
			int dy = y + dirs[i][1];
			if(dx>=0 && dy>=0 && dx<R && dy<C && !visited[map[dx][dy]]) {
				visited[map[dx][dy]] = true;
				go(dx, dy, count+1);
				visited[map[dx][dy]] = false;
			}
		}
	}
}
