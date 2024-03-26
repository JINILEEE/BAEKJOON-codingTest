package no2563;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	/**
	 * 색종이: 가로,세로 크기가 각각 100인 정사각형 모양 도화지 위에 
	 * 가로,세로 각각 10인 정사각형 색종이로  평행하도록 붙인다.
	 * 색종이를 1장 이상 붙인 후 검은 영역의 넓이를 구하라
	 */
	public static void main(String[] args) throws IOException {

		/**
		 * 사용한 색종이 수, 한줄에 하나씩 색종이를 붙인 위치를 각각 입력받고,
		 * 그 위치부터 10씩 증가한 2차 배열 만들고
		 * 겹치는 부분이 있다면 그 부분은 무시하고 면적값 구하기
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = 0; //검은 영역 넓이
		int N = Integer.parseInt(br.readLine()); // 색종이 개수
		boolean [][] arr = new boolean [100][100]; // 색종이 위치(true면 해당영역이 색종이로 덮인것)
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // 열 가로
			int y = Integer.parseInt(st.nextToken()); // 행 세로
			
			for(int j=x; j<x+10; j++) {
				for(int k=y; k<y+10; k++) {
					// 도화지 배열의 해당 위치에 색종이가 덮여있지 않을때만 코드실행
					if(!arr[j][k]) {
						arr[j][k] = true;
						total++;
					}
				}
			}
		}
		System.out.println(total);
		
	}//main
	
}//class
