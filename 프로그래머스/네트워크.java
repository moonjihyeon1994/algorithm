
public class 匙飘况农 {
	private boolean[] visited;
	private int answer;

	public int solution(int n, int[][] computers) {
        answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
        	if(!visited[i]) {
        		answer++;
        		go(i, computers);
        	}
		}
        
        return answer;
    }

	private void go(int n, int[][] computers) {
		visited[n] = true;
		
		for (int i = 0; i < computers[n].length; i++) {
			if(i==n) continue;
			if(computers[n][i]==1 && !visited[i]) {
				go(i, computers);
			}
		}
		
	}

	public static void main(String[] args) {
		匙飘况农 s = new 匙飘况农();
		System.out.println(s.solution(3, new int[][] {{1,1,0},{1,1,0},{0,0,1}}));
	}
}
