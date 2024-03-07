package no11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	/**
	 * 요세푸스 순열: 1-N으로 이루어진 원에서 K(<=N) 번째 숫자 제거후 남은 숫자들로 이 과정 반복
	 */
	public static void main(String[] args) throws IOException {

		/**
		 * 입력받고, N,K 생성
		 * 큐를 사용해 K번째 수마다 차례로 뽑아낸 수열출력
		 * K번째 수 직전까지 맨 앞의 원소를 K-1번 꺼내고(poll)
		 * 꺼낸 원소들을 맨 뒤에 넣는다.(offer)
		 * K번째 뽑힌(poll) 원소는 출력하면 되는 것이다.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 나중에 결과를 저장하기 위해 생성
		StringBuilder sb = new StringBuilder();
		sb.append("<"); // 초기에 < 를 만들어 둔것
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=1; i<=N; i++) {
			q.offer(i); //queue에서 offer()는 큐에 데이터 추가
		} // 큐에 초기값(K번째 숫자까지)을 삽입한 것
		
		int cnt=0;
		
		// 큐의 크기가 1이 될때까지 진행해 숫자 하나빼기
		// K의 배수에 해당하면 결과 문자열에 추가하고(,와 공백포함)
		// 그렇지 않으면 다시 큐에 해당 숫자를 추가
		while(q.size() != 1) {
			int data = q.poll(); //.remove()와 다르게 큐가 비어있으면 예외가 아닌 null을 반환한다.
			cnt++;
			if(cnt%K == 0) {
				sb.append(data).append(", ");
			}else {
				q.add(data);
			}
		}
		
		sb.append(q.poll()).append(">");
		System.out.println(sb);
		
	}//main

}//class
