package no15650;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	/**
	 * N과 M(2)
	 * 1부터 N까지 중에서 중복없이 M개를 고른 수열
	 * 오름차순
	 */
	
	public static int N;
	public static int M;
	public static int[] arr;
	public static boolean[] check;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		/**
		 * N과 M 입력받고
		 * int형 배열에는 M을 boolean형 배열은 N만큼의 크기로 생성
		 * dfs(깊이 우선 탐색) 알고리즘을 사용해 모든 가능한 조합을 탐색
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		check = new boolean[N]; // 각 숫자가 사용되었는지 여부를 확인
		arr = new int[M]; // 결과로 만들어질 수열 저장
		dfs(0,0); // dfs탐색 시작
		System.out.println(sb);
		
	}//main

	// dfs함수에서는 현재까지의 깊이(depth)와 시작인덱스(start)를 인자로 받음
	private static void dfs(int depth, int start) {
		if(depth == M) {         //현재까지의 깊이가 M과 같다면, 즉 원하는 길이의 수열을 만들었다면 결과를 출력
			for(int val : arr) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<N; i++) {
			if(!check[i]) {
				check[i] = true; // 해당 숫자를 사용했다고 표시하고(check[i] = true), 수열에 넣은 후에 재귀적으로 다음 단계를 진행
				arr[depth] = i+1;
				dfs(depth+1, i+1);
				check[i] = false; // 재귀 호출이 끝나면 사용했던 숫자를 다시 돌려놓음(check[i] = false)
			}
		}
		
	}//dfs
	
}//class
