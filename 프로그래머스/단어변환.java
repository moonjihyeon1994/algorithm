
public class 단어변환 {
	private int min;
	private boolean[] visited;

	public int solution(String begin, String target, String[] words) {
		boolean check = false;
		for (int i = 0; i < words.length; i++) {
			if(words[i].equals(target)) check = true;
		}
		if(!check) return 0;
		
		visited = new boolean[words.length];
		min = Integer.MAX_VALUE;
		swap(begin, target, 0, words);
		
		return min;
	}

	private void swap(String word, String target, int idx, String[]words) {
		if(word.equals(target)) {
			if(min>idx) min = idx;
			return;
		}
		if(idx>words.length) return;
		
		for (int i = 0; i < words.length; i++) {
			if(!visited[i]) {
				int count = 0;
				for (int j = 0; j < word.length(); j++) {
					if(word.charAt(j)==words[i].charAt(j)) count++;
				}
				
				if(count >= word.length()-1) {
					visited[i] = true;
					swap(words[i], target, idx+1, words);
					visited[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		단어변환 s = new 단어변환();
		System.out.println(s.solution("hit", "cog", new String[] { "hot", "dot", "dog", "lot", "log", "cog" }));
	}
}
