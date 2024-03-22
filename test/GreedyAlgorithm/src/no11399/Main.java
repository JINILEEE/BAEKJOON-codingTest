package no11399;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	/**
	 * ATM
	 * N명이 ATM에서 인출하기 위해 걸리는 시간의 합
	 * 최솟값으로 
	 */
	public static void main(String[] args) throws IOException {
		
		/**
		 * N, 각각이 걸리는 시간(Pi)을 입력받고
		 * 순차합을 구하기
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] Pi = new int[N];
		
		for(int i=0; i<N; i++) {
			Pi[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		int result = 0;
		
		Arrays.sort(Pi); // Pi 배열을 오름차순으로 정렬(최소한의 대기시간을 구해야하므로)
		
		// 총 걸리는 시간 계산
		for(int i=0; i<N;i++) {
			sum += Pi[i];
			result += sum;
		}
		
		/**
		 * String.valueOf() : 매개변수로 전달된 값을 문자열로 변환, 문자열을 출력.
		 * System.out.println() : 메서드는 인자로 전달된 값을 표준 출력 스트림에 출력, 문자열, 숫자, 객체 등 다양한 종류의 데이터를 출력
		 */
		bw.write(String.valueOf(result));
		System.out.println(result);
		
		bw.close();
		br.close();
		
	}//main
	
}//class
