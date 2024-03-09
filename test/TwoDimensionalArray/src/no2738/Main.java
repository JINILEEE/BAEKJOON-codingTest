package no2738;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	/**
	 * N*M크기의 행렬 A,B가 각각 주어질 때,
	 * 두 행렬을 더하기
	 */
	public static void main(String[] args) throws IOException{
		
		/**
		 * N, M을 입력받기
		 * A, B를 입력받기
		 * 각각의 원소끼리 더해주기
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); // 첫 번째 줄에서 공백을 기준으로 문자열을 토큰화하기 위해
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] A = new int[N][M];
		int[][] B = new int[N][M];
		
		// 2차원 배열 A의 값을 받아 저장
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 2차원 배열 B의 값을 받아 저장
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(A[i][j] + B[i][j] + " "); // 두 행렬의 같은 위치에 있는 원소를 더하고, 그 결과를 문자열에 추가
			}
			sb.append("\n"); // 각 행의 끝에 개행(줄바꿈) 문자를 추가해 행렬 형태를 유지
		}
		
		System.out.println(sb);
		
	}//main
	
}//class
