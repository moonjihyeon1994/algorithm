import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17779 {
	public static class point {
		int x;
		int y;
		int color;
		public point(int x, int y, int color) {
			this.x = x;
			this.y = y;
			this.color = color;
		}
	}
	private static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int[][]map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				for (int d1 = 1; d1 <= N; d1++) {
					for (int d2 = 1; d2 <= N; d2++) {
						
						if(i+d1>=0 && j-d1>=0 && i+d1+d2>=0 && j-d1+d2>=0 && i+d2>=0 && j+d2>=0 &&
							i+d1<N && j-d1<N &&	i+d1+d2<N && j-d1+d2<N && i+d2<N && j+d2<N) {
							int[][] visited = new int[N][N];
							visited[i][j] = 5; //위
							visited[i+d1][j-d1] = 5; //왼쪽
							visited[i+d1+d2][j-d1+d2] = 5; //아래
							visited[i+d2][j+d2] = 5; //오른쪽
							
							for (int k = 1; k <= d1; k++) {
								if(visited[i + k][j - k]==5) break;
								visited[i + k][j - k] = 5;
							}
							for (int k = 1; k <= d2; k++) {
								if(visited[i + k][j + k]==5) break;
								visited[i + k][j + k] = 5;
							}
							for (int k = 1; k <= d1; k++) {
								if(visited[i+d2 + k][j+d2 - k]==5) break;
								visited[i+d2 + k][j+d2 - k] = 5;
							}
							for (int k = 1; k <= d2; k++) {
								if(visited[i+d1 + k][j-d1 + k]==5) break;
								visited[i+d1 + k][j-d1 + k] = 5;
							}
							
							visited[i][j] = 5; //위
							visited[i+d1][j-d1] = 5; //왼쪽
							visited[i+d1+d2][j-d1+d2] = 5; //아래
							visited[i+d2][j+d2] = 5; //오른쪽
							
							for (int k = 1; k <= N; k++) {
								if(i-k<0) break;
								visited[i-k][j] = 1;
							}
							for (int k = 1; k <= N; k++) {
								if(j-d1-k<0) break;
								visited[i+d1][j-d1-k] = 3;
							}
							for (int k = 1; k <= N; k++) {
								if(i+d1+d2+k==N) break;
								visited[i+d1+d2+k][j-d1+d2] = 4;
							}
							for (int k = 1; k <= N; k++) {
								if(j+d2+k==N) break;
								visited[i+d2][j+d2+k] = 2;
							}
							
							//색칠
							color(visited);
							
							//갯수세기
							int[]count = new int[5];
							for (int k = 0; k < N; k++) {
								for (int k2 = 0; k2 < N; k2++) {
									if(visited[k][k2]==0) {
										count[4] += map[k][k2];
									}else {
										count[visited[k][k2]-1] += map[k][k2];
									}
								}
							}
							
							int min = Integer.MAX_VALUE;
							int max = Integer.MIN_VALUE;
							for (int k = 0; k < count.length; k++) {
								if(min>count[k]) min=count[k];
								if(max<count[k]) max=count[k];
							}
							if(answer>max-min) answer = max-min;
						}
					}
				}
			}
		}
		System.out.println(answer);
	}
	
	static int[][]dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	private static void color(int[][] visited) {
		Queue<point> q = new LinkedList<>();
		q.add(new point(0, 0, 1));
		q.add(new point(0, N-1, 2));
		q.add(new point(N-1, 0, 3));
		q.add(new point(N-1, N-1, 4));
		
		while(!q.isEmpty()) {
			point point = q.poll();
			int x = point.x;
			int y = point.y;
			for (int i = 0; i < 4; i++) {
				int dx = x + dirs[i][0];
				int dy = y + dirs[i][1];
				if(dx>=0 && dy>=0 && dx<N && dy<N && visited[dx][dy]==0) {
					visited[dx][dy] = point.color;
					q.add(new point(dx, dy, point.color));
				}
			}
		}
	}
}
