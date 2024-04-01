package no15651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	/**
	 * N과 M (3)
	 * 첫째 줄에 자연수 N과 M이 주어지고 
	 * N개의 줄에 M개씩 각 수열은 공백으로 구분해서 출력하고
	 * 중복되는 수열은 반복출력 안됨
	 * 수열은 사전 순으로 증가하는 순서
	 */
	
	public static StringBuilder sb = new StringBuilder();
	public static int N, M;
	public static int[] arr;
	
	public static void main(String[] args) throws IOException {
		/**
		 * StringTokenizer로 하나씩 나눠서 N과 M을 입력받고
		 * N개의 수열 M을 출력하기 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		boolean[] check = new boolean[N];
		def(0); // 재귀적으로 모든 경우의 수를 생성하는 역할
		System.out.println(sb);
		
	}//main

	// 재귀호출을 이용해 숫자선택해서 모든 숫자가 선택되면 출력
	private static void def(int depth) {
		if(depth == M) {
			for(int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 0;i < N;i++) {
			arr[depth] = i + 1;
			def(depth + 1);
		}
	}//def
	
}//class
