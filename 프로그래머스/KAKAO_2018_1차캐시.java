import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class KAKAO_2018_1차캐시 {
	public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		if(cacheSize == 0) return cities.length * 5;
		
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < cities.length; i++) {
			String temp = cities[i].toUpperCase();
			if(map.containsKey(temp)) {
				map.put(temp, i);
				answer++;
			}else {
				map.put(temp, i);
				answer += 5;
				if(map.size()>cacheSize) {
					int min = Integer.MAX_VALUE;
					String key = "";
					for (Entry<String, Integer> ent : map.entrySet()) {
						if(min>ent.getValue()) {
							min = ent.getValue();
							key = ent.getKey();
						}
					}
					map.remove(key);
				}
			}

		}
		return answer;
	}

	public static void main(String[] args) {
		KAKAO_2018_1차캐시 s = new KAKAO_2018_1차캐시();
		System.out.println(s.solution(3, new String [] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
	}
}
