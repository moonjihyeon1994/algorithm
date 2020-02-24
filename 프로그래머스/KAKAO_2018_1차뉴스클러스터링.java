import java.util.ArrayList;
import java.util.List;

public class KAKAO_2018_1차뉴스클러스터링 {
	public int solution(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		if(str1.equals(str2)) return 65536;
		int answer = 0;
		
		List<String>one = new ArrayList<>();
		List<String>two = new ArrayList<>();
		
		for (int i = 0; i < str1.length()-1; i++) {
			if('a'<=str1.charAt(i) && str1.charAt(i)<='z' && 'a'<=str1.charAt(i+1) && str1.charAt(i+1)<='z') {
				one.add(str1.substring(i,i+2));
			}
		}
		for (int i = 0; i < str2.length()-1; i++) {
			if('a'<=str2.charAt(i) && str2.charAt(i)<='z' && 'a'<=str2.charAt(i+1) && str2.charAt(i+1)<='z') {
				two.add(str2.substring(i,i+2));
			}
		}
		
		int n = 0;
		int u = 0;
		
		boolean[] visited = new boolean[two.size()];
		for (int i = 0; i < one.size(); i++) {
			for (int j = 0; j < two.size(); j++) {
				if(!visited[j] && one.get(i).equals(two.get(j))) {
					visited[j] = true;
					n++;
					break;
				}
			}
		}
		u = one.size()+two.size()-n;
		answer = (int) Math.floor(((double)n/u)*65536);
		return answer;
	}

	public static void main(String[] args) {
		KAKAO_2018_1차뉴스클러스터링 s = new KAKAO_2018_1차뉴스클러스터링();
		System.out.println(s.solution("FRANCE","french"));
	}
}
