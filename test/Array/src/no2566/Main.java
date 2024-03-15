package no2566;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 방법1. 2차원 배열로 풀기
 */

public class Main {

	/**
	 * 최댓값 구하기
	 * 9X9 격자팜에 쓰여진 81개의 자연수 또는 0 중에서
	 * 최댓값을 찾고 그 위치가 몇 행 몇 열에 위치한 수인지 구하기
	 */
	public static void main(String [] args) throws IOException {
		
		/**
		 * 2차 배열 입력값을 받고
		 * 각 값들 비교해보기
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] arr = new int[9][9];
		
		// 배열 인덱스는 0부터 시작하므로 무조건 0부터 시작으로 작성해야만한다!!!
		for(int i=0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		
		int max = arr[0][0];
		int row = 0;
		int column = 0;
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(max<arr[i][j]) {
					max = arr[i][j];
					
					// 이 부분에 row = i+1; 로 작성하면 배열이 0부터시작이 아니라 1부터 돌게되므로 잘못된 코드가 된다!!
					row = i; 
					column = j;
				}
			}
		}
		System.out.println(max + "\n" + (row+1) + " " + (column+1));
	}//main
	
}//class
