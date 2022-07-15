package ch04;
//10989번
//수 정렬하기 3
//기수정렬
import java.util.Scanner;

public class q022 {
	
	public static int[] A;
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		A = new int[N];
		
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		radix_sort(A, 5);
		for(int i=0; i<N; i++) {
			System.out.println(A[i]);
		}
		
	}
	
	public static void radix_sort(int[] A, int max) {
		
		int[] output = new int[A.length];
		int jarisu = 1;
		int count = 0;
		
		while(count != max) {
			int[] bucket = new int[10];
			for(int i=0; i<A.length; i++) {
				//해당 자리수를 가진 요소가 몇개인지 0~9 배열에 저장
				bucket[(A[i]/jarisu)%10]++;
			}
			
			for(int i=1; i<10; i++) {
				//합 배열로 해당 자리수 가진 요소가 어디부터 어디 인덱스에 존재하는지 
				//알 수 있게 한다.
				bucket[i] += bucket[i-1];
			}
			
			//이해는 했지만 그냥 외워버리는게 낫겠다.
			for(int i=A.length-1; i>=0; i--) {
				//합 배열의 값을 이용해서 합배열 인덱스의 자리수를 가진 요소를
				//있어야 할 인덱스에 넣는다..
				output[bucket[(A[i]/jarisu) % 10]-1] = A[i];
				bucket[(A[i]/jarisu) % 10]--;
			}
			
			for(int i=0; i<A.length; i++) {
				A[i] = output[i];
			}
			
			jarisu *= 10;
			count++;
		}
	}
	
	
}
