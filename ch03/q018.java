package ch03;
//백준온라인 11399
//ATM 인출 시간 계산하기
//삽입 정렬로 오름차순 정렬하고 합배열 마지막 요소 출력하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q018 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		int[] S = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i]=Integer.parseInt(st.nextToken());
		}
		
		//인덱스0은 처음부터 비교대상이 되므로 1부터 시작한다.
		for(int i=1; i<N; i++) {
			int imsi_value = A[i];//삽입할 값 임시 저장
			int insert_index = 0;//값을 삽입할 배열의 인덱스
			//기준 인덱스의 왼쪽 값부터 0까지 하나씩 왼쪽으로
			for(int j=i-1; j>=0; j--) {
				//기준인덱스 배열 값보다 비교하는 인덱스 배열 값이 작으면
				if(A[i]>A[j]) {
					//비교되는 인덱스보다 1 큰 값이 삽입할 인덱스가 된다.
					insert_index = j+1;
					break;
				}
				//모든 값들이 기준 인덱스 배열의 값보다 크면 삽입 인덱스는 0이된다.
				else if(j==0) {
					insert_index = 0;
				}
			}
			//기준 인덱스부터 삽입 인덱스까지 오른쪽으로 이동
			for(int j=i; j>insert_index; j--) {
				A[j] = A[j-1];
			}
			
			A[insert_index] = imsi_value;
		}
		
		S[0] = A[0];
		int sum = 0;
		//합 배열 계산
		for(int i=1; i<N; i++) {
			S[i] = S[i-1] + A[i];
		}
		for(int i=0; i<N; i++) {
			sum = sum + S[i];
		}
		
		System.out.println(sum);
	}
}
