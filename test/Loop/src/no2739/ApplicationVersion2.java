package no2739;

public class ApplicationVersion2 {

	/**
	 * 1~100까지 합
	 * 그 중 짝수끼리 합
	 * 그 중 홀수끼리 합
	 */
	public static void main(String[] args) {
		
		int totalSum = 0;
		int oddSum = 0;
		int evenSum1 = 0;
		int evenSum2 = 0;
		
		// 1~100까지 덧셈
		for(int i = 1; i <= 100; i++) {
			totalSum = totalSum + i;
		}
		System.out.println("1부터 100까지 합은 " + totalSum + " 입니다.");
		
		// 1~100까지 홀수 덧셈
		for(int i = 1; i <= 100; i++) {
			if(i%2 == 0) {
				continue;
			}
			oddSum = oddSum + i;
		}
		System.out.println("1부터 100까지 홀수 합은 " + oddSum + " 입니다.");
		
		// 1~100까지 수 덧셈
		evenSum1 = totalSum - oddSum;
		System.out.println("방법1: 1부터 100까지 홀수 합은 " + evenSum1 + " 입니다.");
		
		for(int i = 1; i <= 100; i++) {
			if(i%2 != 0) {
				continue;
			}
			evenSum2 = evenSum2 + i;
		}
		System.out.println("방법2: 1부터 100까지 홀수 합은 " + evenSum2 + " 입니다.");
		
	}//main
	
}//class
