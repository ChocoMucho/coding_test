package ch03;

//백준 온라인 2750번
//수 정렬하기
//오름차순 버블 정렬

import java.util.Scanner;
public class q015 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		
		//배열의 마지막과 그 앞까지만 비교하기 때문에 
		//범위는 마지막의 한칸 앞까지만 한다.
		for(int i=0; i<N-1; i++) {
			//for문이 한번씩 돌 때마다 제일 큰 수는 정렬이 되기 때문에
			//정렬 범위를 한 칸 씩 줄여나간다.
			for(int j=0; j<N-1-i; j++) {
				if(A[j]>A[j+1]) {
					int imsi = A[j];
					A[j] = A[j+1];
					A[j+1] = imsi;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			System.out.println(A[i]);
		}
	}
}
