package ch03;
//백준 온라인 1253번
//'좋은 수' 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q008 {
	public static void main(String[] args)throws IOException {
		System.out.println("수의 개수를 입력하세요");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int A[] = new int[N];
		int count = 0;
		
		System.out.println("개수에 맞춰 수를 입력하세요");
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		for(int K=0; K<N; K++) {
			int i = 0;
			int j = N-1;
			int f = A[K];
			
			while(i<j) {//각 포인터가 만나지 않는 상태
				if(A[i]+A[j]==f) {//각 포인터 값의 합이 찾는 수와 같을 때
					if(i!=f && j!=f) {//양 포인터의 값이 찾는 수와 같지 않을 때
						count++;
						break;
						}
					else if(i==f) {
						i++;
						}
					else if(j==f) {//ex) i=0, j=f라면 끝 포인터를 줄인다.
						j--;
						}
				}else if(A[i]+A[j]<f) {//합이 작으면 시작 포인터 값을 올린다.
					i++;
				}else {//합이 크면 끝 포인터 값을 줄인다.
					j--;
				}
			}
		}
		System.out.println(count);
		
	}
}
