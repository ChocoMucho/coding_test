package ch04;
//백준 온라인 1517번
//버블 소트 프로그램(인 척하는 머지 솔트)

import java.util.Scanner;

public class q021 {
	public static int result = 0;
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
		
		merge_sort(1, N);
		
		System.out.println(result);
		System.out.println();
		for(int i=1; i<=N; i++) {
			System.out.println(A[i]);
		}
	}
	
	private static void merge_sort(int s, int e) {
		if(e-s < 1)return;
		int m = s + (e-s)/2;
		merge_sort(s, m);
		merge_sort(m+1, e);
		
		for(int i=s; i<=e; i++) {//시작점부터 끝점까지
			tmp[i] = A[i];//임시 배열에 넣는다.
		}
		
		int index1 = s;//양단 후 앞 부분 시작 인덱스
		int index2 = m+1;//      뒷 부분 시작 인덱스
		int k = s;//시작점부터 1증가할 인덱스
		
		while(index1<=m && index2<=e) {
			if(tmp[index2]<tmp[index1]){//뒷배열 해당 인덱스 배열 값이 더 작을 경우
				A[k] = tmp[index2];//뒷 배열 인덱스 배열 값을 넣는다
				k++; index2++;
				result += (m+1)-index1; // 중간값 + 1 에서 앞 인덱스를 빼면 앞 배열 남은 개수이다.
			}
			else {
				A[k] = tmp[index1];//앞 배열 인덱스 배열 값을 넣는다
				k++; index1++;
			}
		}
		while(index1<=m) {
			A[k] = tmp[index1];
			k++; index1++;
		}
		while(index2<=e) {
			A[k] = tmp[index2];
			k++; index2++;
		}
	}
}
