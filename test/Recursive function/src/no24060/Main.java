package no24060;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	/**
	 * N개의 서로 다른 양의 정수가 저장된 배열 A
	 * 병합 정렬로 배열 A를 오름차순 정렬할 경우 배열 A에 K 번째 저장되는 수를 구하기.
	 * 배열 A에 K 번째 저장 되는 수를 출력한다. 
	 * 저장 횟수가 K 보다 작으면 -1을 출력한다.
	 */
	
	/**
	 * 하나의 리스트를 두 개의 균등한 크기로 분할
	 * 분할된 부분 리스트를 정렬
	 * 두 개의 정렬된 부분 리스트를 합하여 전체가 정렬된 리스트 완성
	 * 
	 * 분할(Divide): 입력 배열을 같은 크기의 2개의 부분 배열로 분할한다.
	 * 정복(Conquer): 부분 배열을 정렬한다. 부분 배열의 크기가 충분히 작지 않으면 순환 호출 을 이용하여 다시 분할 정복 방법을 적용한다.
	 * 결합(Combine): 정렬된 부분 배열들을 하나의 배열에 합병한다.
	 */
	
	static int count, result, N, K , A[], temp[]; // A[]: 입력받은 배열

    public static void main(String[] args) throws IOException {
        
    	// 입력받기위해 BufferedReader, StringTokenizer 생성후 N,K 를 입력받기
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stz.nextToken());
        K = Integer.parseInt(stz.nextToken());

        // 두 번째 줄에서 배열 A에 정수를 입력받기
        stz = new StringTokenizer(br.readLine());
        A = new int[N + 1];
        temp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(stz.nextToken());
        }
        
        // mergeSort 메소드 호출해 배열 정렬, count가 K를 초과하면 -1출력하고 종료.
        mergeSort(1, N);
        System.out.println(-1);

    }

    // count가 K를 초과하면 더이상의 작업을 수행하지 않는 메소드로 병합정렬 구현
    private static void mergeSort(int p, int r) {
        if(count > K ) return;
        int q;
        if (p < r) {
            q = (p + r) / 2;
            mergeSort(p, q);
            mergeSort(q + 1, r);
            merge(p, q, r);
        }
    }

    // 이미 정렬된 두 부분 배열을 합병. count가 K와 일치하면 결과값 출력하고 프로그램 종료
    private static void merge(int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 1;
        
        while (i <= q && j <= r) {    // 왼쪽과 오른쪽 배열 비교, 둘 중 하나라도 끝에 도달할때까지 반복
            
        	// 비교하는 왼쪽이 오른쪽보다 작거나 같으면 temp에 왼쪽값을 저장
        	if (A[i] <= A[j]) {
                temp[t++] = A[i++];
            } else {
                temp[t++] = A[j++];
            }
        }

        while (i <= q) {
            temp[t++] = A[i++];
        }

        while (j <= r) {
            temp[t++] = A[j++];
        }

        // 배열을 합병한 후 다시 i를 왼쪽배열의 시작으로, t를 1로 초기화
        i = p;
        t = 1;

        // temp에 저장한 값을 다시 원래배열 A에 복사하면서 count 증가시킴
        while (i <= r) {
            A[i++] = temp[t++];
            count++;
            
            // count가 K와 일치하면 result 출력 후 프로그램 종료
            if (count == K) {
                result = A[i - 1];
                System.out.println(result);
                System.exit(0); // 자바 프로그램 정상종료시 사용
            }
        }
    }

}//class
