package no24060;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice {

	static int count, result, N, K , A[], temp[];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		A = new int[N + 1];
        temp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        mergeSort(1, N);
        System.out.println(-1);
		
	}//main

	private static void mergeSort(int p, int r) {
		if(count > K ) return;
        int q;
        if (p < r) {
            q = (p + r) / 2;
            mergeSort(p, q);
            mergeSort(q + 1, r);
            merge(p, q, r);
        }
	}//mergeSort

	private static void merge(int p, int q, int r) {
		int i = p;
        int j = q + 1;
        int t = 1;
        
        while (i <= q && j <= r) {    
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
        
        i = p;
        t = 1;

        while (i <= r) {
            A[i++] = temp[t++];
            count++;
            
            if (count == K) {
                result = A[i - 1];
                System.out.println(result);
                System.exit(0); 
            }
        }
	}//merge
	
}//class
