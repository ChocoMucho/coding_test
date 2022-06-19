package ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q003 {
	public static void main(String[] args)throws IOException{
		System.out.println("숫자 개수와 질의 개수를 입력하세요");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		
		int N = Integer.parseInt(stringTokenizer.nextToken());
		int Q = Integer.parseInt(stringTokenizer.nextToken());
		
		System.out.println("숫자들을 개수에 맞춰 띄어 입력하세요");
		int A[] = new int[N+1];
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		
		for(int i=1; i<=N; i++) {
			A[i] = A[i-1] + Integer.parseInt(stringTokenizer.nextToken());
		}
		
		System.out.println("질의를 띄어 입력하세요");
		for(int q=0; q<Q; q++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int i = Integer.parseInt(stringTokenizer.nextToken());
			int j = Integer.parseInt(stringTokenizer.nextToken());
			
			System.out.println(A[j]-A[i-1]);
		}
		
		
	}
}