package no12789;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	/**
	 * 번호표를 뽑아 순서대로 간식배부
	 * 첫째 줄에 승환이 앞에 서있는 학생수(N),
	 * 두번째 줄에는 1~N 순서로 앞에서 뒤로 주어짐.
	 * 간식을 받아야할 순서면 빠져나가고,
	 * 아니라면 Stack에서 대기하는 사람과 비교해 그 사람 순서도 아니면 Stack에 저장
	 * 승환이 간식을 받으면 'Nice' 아니면 'Sad' 출력  
	 */
	public static void main(String[] args) throws IOException {
		
		/**
		 * 대기열을 큐로 만들고,
		 * 간식 순서가 맞지 않는 학생은 추가 대기열로 보내는데 이 대기열을 스택으로 만들기
		 * 큐와 스택 모두 대기열이라 둘다 검사하기!
		 */
		
		// System.in = 콘솔에서 입력받기 
		// InputStreamReader = 콘솔에서 입력받은 키를 문자스트림으로 변환 (StreamReader는 한글자씩밖에 저장하게 돼서 비효율)
		// BufferedReader = 문자스트림을 저장하는 buffer 입력객체 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 승환이 앞에 있는 학생들의 수만큼 순서를 저장하는 배열
		int N = Integer.parseInt(br.readLine()); 

		Queue<Integer> q = new LinkedList<>(); // 대기열
		Stack<Integer> s = new Stack<>(); // 추가 대기열
		
		// StringTokenizer = 문자들을 분리하거나, 특정 문자에 따라 문자열을 나누고 싶을 때 사용
		// 1) 띄어쓰기 기준으로 문자열을 분리 -> StringTokenizer st = new StringTokenizer(문자열);
		// 2) 구분자를 기준으로 문자열을 분리 -> StringTokenizer st = new StringTokenizer(문자열, 구분자);
		// 3) 구분자를 기준으로 문자열을 분리할 때 구분자도 토큰으로 넣는다. (true)
		//    구분자를 분리된 문자열 토큰에 포함 시키지 않는다.(false) 디폴트 값은 false다.
		//    StringTokenizer st = new StringTokenizer(문자열, 구분자, true/false);
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++) {
			//offer() = Queue가 꽉 찬 경우 false 반환
			q.offer(Integer.parseInt(st.nextToken()));
		}
		
		int start = 1; // 간식 먹는 순서
		
		while(!q.isEmpty()) {
			if(q.peek() == start) { //queue에서 peek()은 가장 먼저 삽입된 데이터값을 확인하는 것이다.
				q.poll(); //queue의 가장 먼저 삽입된 데이터를 제거할 수 있다.
				start++;
			}else if(!s.isEmpty() && s.peek() == start) { // stack도 대기열이므로 검사해야한다. 
				s.pop(); // stack에서 가장 위에 있는 element를 제거한다.
				start++;
			}else {
				s.push(q.poll()); //queue에서 빼서 stack에 저장
			}
		}//while
		
		while(!s.isEmpty()) {
			if(s.peek() == start) {
				s.pop();
				start++;
			}else {
				System.out.println("Sad");
				return;
			}
		}
		
		System.out.println("Nice");
		
	}//main

}//class
