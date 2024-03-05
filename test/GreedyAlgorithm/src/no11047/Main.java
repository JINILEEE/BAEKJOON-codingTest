package no11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	/**
	 * 동전0
	 * 가지고 있는 동전은 N종류, 각각을 매우 많이 가지고 있다.
	 * 적절히 사용해 합을 K로 만들때, 필요한 동전 개수의 최솟값
	 * 탐욕 알고리즘(Greedy algorithm): 최적해를 구하는 데에 사용되는 근사적인 방법으로
	 * 매 단계마다 최적이라고 생각되는 선택을 하면서 최종적으로 전체적으로 최적인 해답을 찾아내는 과정
	 */
	
	public static void main(String[] args) throws IOException {
		
		/**
		 * 입력받고, K보다 작은 숫자 중 가장 큰 숫자(A) 선택
		 * (K/A) 해서 몫과 나머지 구하기 
		 * 위의 상황 반복
		 * 나머지가 0이 되면 종료
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer는 split과 다르게 정규식을 기반으로 사용할 필요 없다.
		// 단지 공백을 기준으로 끊어준다. 예로 "this is my string"은 this, is, my, string 4개의 스트링으로 끊어주는 기능을 한다.
		StringTokenizer st = new StringTokenizer(br.readLine()); 

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] value = new int[N];
		int count = 0;
		
		//동전의 가치들을 배열에 저장
		for(int i=0; i<N; i++) {
			value[i] = Integer.parseInt(br.readLine());
		}

		//입력받은 동전의 배열은 오름차순으로 정렬되어있으므로 마지막 인덱스부터(값이 가장 큰) 반복문 시작
		for(int i=N-1; i>=0; i--) {
			//현 시점 돈이 value[i]보다 작아야함
			//여기서 증가하는 동전의 개수는 (K/coin[i])의 몫
			//다음 K값은 위의 계산에서 나머지 값이다.
			if(K>=value[i]) {
				count += K / value[i];
				K = K % value[i];
			}
			if(K==0) {
				break;
			}
		}
		System.out.println(count);
	}//main

}//class
