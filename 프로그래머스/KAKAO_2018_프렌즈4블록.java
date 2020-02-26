import java.util.ArrayList;
import java.util.List;

public class KAKAO_2018_«¡∑ª¡Ó4∫Ì∑œ {
	public static class point{
		int x;
		int y;
		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public int solution(int m, int n, String[] board) {
		int answer = 0;
		
		char[][] map  = new char[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = board[i].charAt(j);
			}
		}
		
		while(true) {
			int before = 0;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if(map[i][j]!='.') before++;
				}
			}
			
			List<point>list = new ArrayList<>();
			for (int i = 0; i < m-1; i++) {
				for (int j = 0; j < n-1; j++) {
					if(map[i][j]!='.' && map[i][j]==map[i+1][j] && map[i][j]==map[i][j+1] && map[i][j]==map[i+1][j+1]) {
						list.add(new point(i, j));
						list.add(new point(i+1, j));
						list.add(new point(i, j+1));
						list.add(new point(i+1, j+1));
					}
				}
			}
			
			for (int i = 0; i < list.size(); i++) {
				map[list.get(i).x][list.get(i).y] = '.';
			}
			
			for (int i = 0; i < n; i++) {
				List<Character> temp = new ArrayList<>();
				for (int j = m-1; j >= 0; j--) {
					if(map[j][i]!='.') temp.add(map[j][i]);
				}
				
				for (int j = 0; j < temp.size(); j++) {
					map[m-j-1][i] = temp.get(j);
				}
				
				for (int j = 0; j < m-temp.size(); j++) {
					map[j][i] = '.';
				}
			}
			
			int after = 0;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if(map[i][j]!='.') after++;
				}
			}
			
			if(before == after) break;
			answer += before - after;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		KAKAO_2018_«¡∑ª¡Ó4∫Ì∑œ s = new KAKAO_2018_«¡∑ª¡Ó4∫Ì∑œ();
		System.out.println(s.solution(4, 5, new String [] {"CCBDE", "AAADE", "AAABF", "CCBBF"}));
	}
}
