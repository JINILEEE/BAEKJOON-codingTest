package no2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	/**
	 * 블랙잭 게임
	 * N장의 카드중 3장을 고르기
	 * 3개의 카드 합 <= M
	 * 위의 카드 합을 출력
	 */
	public static void main(String[] args) throws IOException {

		/**
		 * 배열 순서대로 3개의 숫자끼리 더해보기(조합을 구하는 알고리즘 이용)
		 * 브루트포스: 어떤 값을 찾아내기 위해 무차별적으로 대입하는 방법(노가다)
		 * 이 알고리즘은 '모든 경우의 수를 대입'해보며 조건에 만족하는 값만 찾아내는 것!
		 * 그 합이 > M 이면 return
		 * M에 가장 가까운 숫자 출력
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int result = 0;
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 3개를 고르기 때문에 첫번째 카드는 N-2 까지만 순회
		for(int i=0; i<N-2; i++) {
			
			// 두번째 카드는 첫번째 카드 다음부터 N-1 까지만 순회
			for(int j=i+1; j<N-1; j++) {
				
				// 세번째 카드는 두번째 카드 다음부터 N까지 순회
				for(int k=j+1; k<N; k++) {
					
					// 3개 카드의 합 변수
					int sum = arr[i] + arr[j] + arr[k];
					
					// M과 세카드의 합이 같다면 sum return 및 종료
					if(sum <= M) {
						result = Math.max(result, sum);
					}
				}
			}
		}
		
		System.out.println(result);
		br.close();
		
	}//main

}//class
