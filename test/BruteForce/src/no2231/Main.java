package no2231;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	/**
	 * 분해합: 숫자 216을 입력받은 경우 214 = 197 + 1 + 9 + 7 이렇게 197을 구하는 것
	 * 자연수 N이 있으면 N의 가장 작은 생성자를 구해라
	 */
	public static void main(String[] args) throws IOException {
		
		/**
		 * 입력받은 수 N에서 임의의 숫자 result를 만들어
		 * N - result 하고 result%10 로 각 수에 대한 자릿수 분해하기
		 * 위의 과정 반복하고 생성자 없으면 0
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		br.close();
		
		int result = 0; // 결과값을 저장하는 함수 (생성자가 없으면 0을 출력하기 때문에 초기값은 0)
		
		for(int i=0; i<N; i++) {
			int number = i;
			int rest = 0;
			
			// 해당 값이 0보다 작아질때까지 반복
			while(number>0) {
				rest += number % 10; // 자리수를 10씩 분해해서 해당 자리수의 모든 값을 더해(누적)
				number /= 10; // number값을 10으로 나눈값을 number에 저장
			}
			if(rest + i == N) {
				result = i; // 생성자라는 뜻이라 i를 대입해줌
				 break;
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		
	}//main
	
}//class
