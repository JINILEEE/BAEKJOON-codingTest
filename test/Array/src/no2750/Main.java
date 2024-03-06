package no2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	/**
	 * N개의 수가 주어지면 오름차순으로 정렬
	 */
	public static void main(String[] args) throws IOException {

		/**
		 * N값 입력받기
		 * 최솟값부터 출력 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 정수 개수
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine()); // 배열에 정수 입력받기
		}
		
		// Arrays.sort(): 배열을 정렬할때 사용하는 메소드로 배열을 오름차순으로 정렬한다.
		Arrays.sort(arr);

		for(int i=0; i<N; i++) {
			System.out.println(arr[i]);
		}
		
	}//main

}//class
