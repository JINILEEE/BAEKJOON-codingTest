package no19532;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	/**
	 * 연립방정식 풀기
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		br.close();
		
		//첫 번째 식
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		//두 번째 식
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		
		//각각의 i=x, j=y에 대입해보면
		for(int i = -999; i <= 999; i++) {
			for(int j = -999; j <= 999; j++) {
				if(a*i + b*j == c) {
					if(d*i + e*j == f) {
						bw.write(i + " " + j);
						break;
					}
				}
			}
		}
		
		bw.flush();
		bw.close();
		
	}//main
	
}//class
