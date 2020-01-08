import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13458 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[]list = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		long sum = 0;
		for (int i = 0; i < N; i++) {
			list[i] = list[i] - B;
			if(list[i]>0) {
				if(list[i]%C==0) sum += 1+list[i]/C;
				else sum += 1+1+list[i]/C;
			}else {
				sum = sum + 1;
			}
		}
		System.out.println(sum);
	}
}
