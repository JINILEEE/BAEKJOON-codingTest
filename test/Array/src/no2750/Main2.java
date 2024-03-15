package no2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 방법2. StringTokenizer 로 풀이
 */

public class Main2 {

	/**
	 * 최댓값 구하기
	 * 9X9 격자팜에 쓰여진 81개의 자연수 또는 0 중에서
	 * 최댓값을 찾고 그 위치가 몇 행 몇 열에 위치한 수인지 구하기
	 */
	public static void main(String [] args) throws IOException {
		
		/**
		 * 입력값을 받고
		 * StringTokenizer로 풀이
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int max = 0;  // 최댓값을 저장하는 변수
		int row = 0;
		int column = 0;
		
		// 9X9배열의 모든 값을 확인
		for(int i=0; i<9; i++) {
			
			// br.readLine() 을 통해 한줄씩 입력받고, StringTokenizer를 사용하여 공백으로 구분된 각 숫자들을 토큰으로 분리
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<9; j++) {
				
				// 내부 반복문에서는 1부터 9까지 반복하여 각 줄에서 숫자를 읽어와 N에 저장
				int N = Integer.parseInt(st.nextToken());

				// 최댓값만 출력하면 되므로 굳이 모든 값을 2차원 배열에 저장할 필요 없음
				if(max<N) {
					max=N;
					row=i;
					column=j;
				}
			}
		}
		System.out.println(max);
		System.out.println((row+1) + " " + (column+1));
		
		br.close();
	}//main
	
}//class
