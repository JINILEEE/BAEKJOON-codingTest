package no2739;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	/**
	 * N입력받고, 구구단 N단을 출력하는 프로그램
	 */
	public static void main(String[] args) throws IOException {
		
		/**
		 * int N을 입력받기
		 * 출력형식인 N*1부터 N*9까지 출력하기
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=9; i++) {
			System.out.println(N + " * " + i + " = " + N*i);
		}
		
	}//main
	
}//class
