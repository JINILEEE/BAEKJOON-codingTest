package no25501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	/**
	 * 재귀의 귀재 - 팰린드롬(앞에서 읽나 뒤에서 읽나 동일한 문자열)
	 * 각 테스트마다 isPalindrome함수를 이용해
	 * 주어진 문자열이 팰린드롬이면 1, 아니면 0을 반환하는 함수 
	 * 판별과정에서 recursion함수를 몇번 호출하는지 세기
	 */
	
	public static int count = 0; //recursion 호출
	
	public static void main(String[] args) throws IOException {
		
		/**
		 * 입력받고 
		 * N번 반복하면서 각 문자열에대해 팰린드롬 여부 판별
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			String word = br.readLine();
			count = 0;
			sb.append(isPalindrome(word)).append(" ").append(count).append("\n");
		}
		br.close();
		System.out.println(sb);
		
	}//main

	private static int isPalindrome(String word) {
		
		count = 0; //recursion 호출 횟수 초기화
		
		// word문자열의 시작 인덱스(0)부터 끝 인덱스(word.length()-1)를
		// 재귀적으로 팰린드롬 여부를 판별하는 recursion 메소드 호출
		return recursion(word, 0, word.length()-1);
		
	}//isPalindrome
	
	private static int recursion(String word, int start, int end) {
		count++;
		
		// 이 조건은 시작 인덱스와 끝 인덱스가 서로 엇갈린 상태로 참이면 주어진 문자열의 처음부터 끝까지 모든 문자를 비교했다는 의미
		// 즉, 팰린드롬 여부를 판별할 수 있는 최종 상태
		if(start >= end) {return 1;}
		
		//charAt(): String으로 저장된 문자열 중에서 한 글자만 선택해 char타입으로 변환 
		else if(word.charAt(start) != word.charAt(end)) {return 0;}
		else {return recursion(word, start+1, end-1);}
		
	}//recursion
	
}//class
