package no15649;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.imageio.stream.ImageInputStreamImpl;

public class Main {

	/**
	 * 1부터 N까지 자연수 중에서 
	 * 중복 없이 M개를 고른 수열을 모두 구하기
	 */
	
	public static int N;
	public static int M;
	public static int[] arr;
	public static boolean[] check;
	
	//StringBuilder는 String과 다르게 mutable한 성질을 가져서 값이 변할 수 있다.
	//문자열 변경이 빈번하지 않다면 String사용
	//문자열 변경이 빈번하게 변경되고 멀티스레드 환경이면 StringBuffer 사용
	//문자열 변경이 빈번하게 변경되고 멀티스레드 환경이 아니면 StringBuilder 사용
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {

		/**
		 * 백트래킹: 역추적. 노드의 유망성을 판단. 가능성이 없는 경우의 수는 탐색하지 않는다.
		 * 백트래킹을 이용해 방문한 노드를 확인, 검사하기 위한 boolean배열 생성
		 * 탐색 과정에서 값을 담을 int 배열 생성
		 */
		
		// 자연수 N,M을 정의하기 위해 BufferedReader를 사용해 StringTokenizer로 값을 전역변수로 지정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		check = new boolean[N];  //길이가 N인 방문 여부를 나타내는 배열 check을 초기화
		
		NMBackTracking(0);
		System.out.println(sb);
		
	}//main

	// depth를 통해 재귀가 깊어질 때마다 depth를 1씩 증가시켜 M과 같아지면 
	// 더이상 재귀를 호출하지 않고 탐색과정 중 값을 담았던 arr배열을 출력후 return
	private static void NMBackTracking(int depth) {
		
		if(depth == M) {                 //재귀 종료 조건
			//선택한 원소들을 순회하면서 StringBuilder에 각 원소를 추가하고, 원소사이에 공백입력
			for(int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n'); //한 조합이 완성되면 그 결과를 나타기 위해 개행문자(줄바꿈문자:\n)를 StringBuilder에 추가
			return; //결과 출력후 현재의 재귀호출을 종료하고 이전단계로 돌아감
		}
		//재귀함수 본체로 0~N-1까지 반복해 모든 가능한 수를 확인
		for(int i=0; i<N; i++) {
			
			//만약 해당 노드(값)을 방문하지 않았다면?
			if(!check[i]) {
				check[i] = true; // 해당 노드를 방문상태로 변경
				arr[depth] = i+1; // 해당 깊이를 index로 하여 i+1값 저장
				NMBackTracking(depth+1); // 다음 자식 노드 방문을 위해 depth를 1 증가시키면서 재귀호출
				
				// 자식노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경
				check[i] = false;
			}//if 문
		}//for 문
		
	}//NMBackTracking

}//class
