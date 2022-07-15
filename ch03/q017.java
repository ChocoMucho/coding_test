package ch03;
//백준 온라인 1427번
//내림차순 자릿수 정렬
import java.util.Scanner;

public class q017 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int[] A = new int[str.length()];
		for(int i=0; i<str.length(); i++) {
			//서브스트링 범위를 i, i+1로 해야 i만 입력된다.
			A[i] = Integer.parseInt(str.substring(i,i+1));
		}
		
		for(int i=0; i<str.length(); i++) {
			int max = i;
			for(int j=i+1; j<str.length(); j++) {
				if(A[j]>A[max]) {
					max = j;
				}
			}
			if(A[i]<A[max]) {
				int imsi = A[i];
				A[i] = A[max];
				A[max] = imsi;
			}
		}
		
		for(int i=0; i<str.length(); i++) {
			System.out.println(A[i]);
		}
	}
}
