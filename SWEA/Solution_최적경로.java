import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_최적경로 {
	public static class point{
		int x;
		int y;
		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static boolean[] visited;
	private static int min;
	private static point[] list;
	private static point company;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= tc; testcase++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			point home = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			company = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			list = new point[N];
			for (int i = 0; i < N; i++) {
				list[i] = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			visited = new boolean[N];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int dis = Math.abs(home.x-list[i].x) + Math.abs(home.y-list[i].y);
				visited[i] = true;
				go(i,0,N,dis);
				visited[i] = false;
			}
			sb.append('#').append(testcase).append(' ').append(min).append('\n');
		}
		System.out.println(sb);
	}

	private static void go(int idx, int cnt, int len, int sum) {
		if(min<sum) return;
		if(cnt==len-1) {
			int dis = Math.abs(list[idx].x-company.x) + Math.abs(list[idx].y-company.y);
			int distance = dis+sum;
			if(min>distance) min = distance;
			return;
		}
		for (int i = 0; i < list.length; i++) {
			if(!visited[i]) {
				int dis = Math.abs(list[idx].x-list[i].x) + Math.abs(list[idx].y-list[i].y);
				visited[i] = true;
				go(i, cnt+1, len, sum+dis);
				visited[i] = false;
			}
		}
	}
}
