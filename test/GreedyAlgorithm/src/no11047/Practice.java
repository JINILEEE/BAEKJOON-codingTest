package no11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] value = new int[N];
		int count = 0;
		
		for(int i = 0;i < N;i++) {
			value[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = N-1; i >= 0; i--) {
			if(K >= value[i]) {
				count += K / value[i];
				K = K % value[i];
			}
			if(K == 0) {
				break;
			}
		}
		
		System.out.println(count);
		
	}//main
	
}//class
