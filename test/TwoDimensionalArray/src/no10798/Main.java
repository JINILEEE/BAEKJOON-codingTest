package no10798;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	/**
	 * 총 5줄의 입력, 각줄에 1-15개 글자들이 연속으로 주어짐.
	 * 'A'-'Z', 'a'-'z', '0'-'9' 중에 가 주어짐.
	 * 각 줄의 시작과 마지막에는 빈칸이 없다.
	 * 왼쪽 맨위에서 시작해 위 -> 아래로 읽어 출력.
	 * 빈칸이면 바로 다음 글자를 읽어 공백없이 출력한다.
	 */
	public static void main(String[] args) throws IOException{

		/**
		 * 입력받고, 5x5 배열에서 출력순서에 따라 출력.
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//5줄, 최대 15글자로된 2차원 배열 선언
		char arr[][] = new char[5][15];
		
		//입력받은 문자 그래도 출력
		for(int i=0; i<arr.length; i++) {
			String str = br.readLine();
			
			// 사용자로부터 문자열을 입력받아 arr 배열에 저장
			for(int j=0; j<str.length(); j++) {
				arr[i][j] = str.charAt(j); //charAt()는 String으로 받은 문자열을 한 글자만 선택해 char타입으로 변환해줌
			}
		}
		
		//입력된 문자열을 세로로 출력, 2중 반복문은 해당 위치에 값이 0이 아니면 출력
		for(int j=0; j<arr[0].length; j++) { //열을 기준으로 반복한다.
			for(int i=0; i<5; i++) { // 각 열에 해당하는 행(row)을 순회한다.
				if(arr[i][j] == 0) {
					continue;
				}
				bw.write(String.valueOf(arr[i][j])); // String.valueOf는 null인 경우 "null"이라는 문자열로 처리
			}
		}
		
		br.close();
		bw.flush(); //flush를 써주지 않으면 출력되지 않는다.
		bw.close();
		
	}//main

}//class
