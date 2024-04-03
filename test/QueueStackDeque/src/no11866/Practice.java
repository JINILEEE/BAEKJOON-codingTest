package no11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<"); 
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=1; i<=N; i++) {
			q.offer(i); 
		} // 큐에 초기값(K번째 숫자까지)을 삽입한 것
		
		int cnt=0;
		
		while(q.size() != 1) {
			int data = q.poll(); 
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
