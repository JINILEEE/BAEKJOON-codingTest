package no2739;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ApplicationVersion {
	
	/**
	 * 구구단 3단 4의 배수 제외 출력하는 자바 코드를 알려줘
	 */
	public static void main(String[] args) {
		
		for(int i = 1; i<10; i++) {
			if(i%4 == 0) {
				continue;
			}
			System.out.println("3 * " + i + " = " + 3*i);
		}
		
		
	}//main
	
}//class
