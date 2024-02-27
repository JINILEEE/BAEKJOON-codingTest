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

public class Practice {

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

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new LinkedList<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++) {
			q.offer(Integer.parseInt(st.nextToken()));
		}
		
		int start = 1;
		
		while(!q.isEmpty()) {
			if(q.peek() == start) {
				q.poll();
				start++;
			}else if(!s.isEmpty() && s.peek() == start) {
				s.pop();
				start++;
			}else {
				s.push(q.poll());
			}
		}
		
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
	}

}
