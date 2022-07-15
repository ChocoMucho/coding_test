package ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q019 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		quickSort(A, 0, N-1, K-1);
		System.out.println(A[K-1]);
		
	}
	
	
	public static void quickSort(int[] A, int s, int e, int K) {
		if(s<e) {
			int pivot = pivoting(A, s, e);
			if(pivot == K) {//우선 퀵정렬 된 피봇 값이 K와 같을 경우
				return;
			}
			else if(K < pivot) {//K가 피봇보다 작으면 피봇값 왼쪽만 정렬
				quickSort(A, 0, pivot -1, K);
			}
			else if(K > pivot) {//K가 피봇보다 크면 피봇값 오른쪽만 정렬				
				quickSort(A, pivot+1, e, K);
			}
		}
	}
	
	public static int pivoting(int[] A, int s, int e) {
		int m = (s + e) / 2;//배열 순서 중간 값
		swap(A, s, m);//원활하기 위해 처음과 중간값 바꾸기
		int pivot = A[s];//처음 값이 피봇(기준값)
		int i = s;//0
		int j = e;//N-1
		while(i<j) {
			while(pivot<A[j]) {//뒤쪽에서 피벗보다 작은 수가 나올 때 까지
				j--;
			}
			while(i<j && pivot>=A[i]) {//앞쪽에서 피벗보다 큰 수가 나올 때 까지
				i++;
			}
			//인덱스가 맞물리지 않고 
			//뒤부터 온 수가 피벗보다 작고, 앞부터 온 수가 피벗보다 클 때
			swap(A, i, j);//큰수는 피벗 뒤로가고 작은 수는 피벗 앞으로 가는 셈
		}
		A[s] = A[i];
		A[i] = pivot;
		return i;//
	}
	
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
