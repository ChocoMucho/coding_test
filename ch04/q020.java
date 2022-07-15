package ch04;

import java.util.Scanner;

public class q020 {
	public static int[] A;
	public static int[] tmp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		A = new int[N+1];
		tmp = new int[N+1];
		for(int i=1; i<=N; i++) {
			A[i] = sc.nextInt();
		}
		merge_sort(1, N+1);
		for(int i=1; i<=N; i++) {
			System.out.println(A[i]);
		}
	}
	
	private static void merge_sort(int s, int e){
		if(e-s < 1) return;
		int m = s + (e-s)/2;
		merge_sort(s, m);//양단 후 왼쪽 범위
		merge_sort(m+1, e);//양단 후 오른쪽 범위
		for(int i=s; i<=e; i++) {
			tmp[i] = A[i];
		}
		int k = s;//원본 배열의 인덱스
		int index1 = s;//왼쪽 범위의 첫 인덱스
		int index2 = m+1;//오른쪽 범위의 첫 인덱스
		while(index1 <= m && index2 <= e) {
			if(tmp[index1]>tmp[index2]) {
				A[k] = tmp[index2];//오른쪽의 값을 대입
				k++;//원본 인덱스 증가
				index2++;
			} else {//각 인덱스에 있는 값이 같거나 index1의 값이 작을 경우
				A[k] = tmp[index1];//왼쪽의 값을 대입
				k++;//원본 인덱스 증가
			}
		}
		
		//한쪽이 조건을 달성하고 나서 나머지 부분의 남은 값을 처리
		while(index1<=m) {
			A[k] = tmp[index1];
			k++;
			index1++;
		}
		
		while(index2<=e) {
			A[k] = tmp[index2];
			k++;
			index2++;
		}
	}
}
