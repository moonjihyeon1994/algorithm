package programmers;

import java.util.Arrays;

public class 주식가격 {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		
		for (int i = 0; i < prices.length; i++) {
			for (int j = i+1; j < prices.length; j++) {
				if(prices[i]<=prices[j]) {
					answer[i]++;
				}else {
					answer[i]++;
					break;
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		주식가격 s = new 주식가격();
		System.out.println(Arrays.toString(s.solution(new int[] {1,2,3,2,3})));
	}
}
