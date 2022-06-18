package ch03;
import java.util.Scanner;

public class q002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long sum = 0;
		long max = 0;
		int N = sc.nextInt();
		int A[] = new int[N];
		
		for(int i=0; i<N; i++) {//점수를 입력 받음
			A[i] = sc.nextInt();
		}
		
		for(int i=0; i<N; i++) {//기준으로 삼을 제일 큰 점수 값을 찾음
			if(max < A[i]) {
				max = A[i];
			}
			sum += A[i];
		}
		
		System.out.println((sum*100)/max/N);
	}
}
