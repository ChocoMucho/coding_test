package ch03;
//백준 온라인 1874번
//스택으로 오름차순 수열 만들기
//예) N=8  4,3,6,8,7,5,2,1
//스택을 1부터 쌓다가 중간에 pop 한 데이터 나열 순서도 똑같아야한다.

import java.util.Scanner;
import java.util.Stack;

public class q011 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		Stack<Integer> stack = new Stack<>();
		
		System.out.println("수열 개수 입력");
		int N = sc.nextInt();
		int[] A = new int[N];
		int natNum = 1;
		String str="";
		boolean res = true;
		
		System.out.println("수 입력(동일한 수 입력 불가)");
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		
		for(int i=0; i<N; i++){
			if(A[i]>=natNum) {
				while(A[i]>=natNum) {
					stack.push(natNum++);
					str+="+\n";
				}
				stack.pop();
				str+="-\n";
			}
			else {
				if(stack.pop()>A[i]) {
					System.out.println("NO");
					res = false;
					break;
				}else {
					
					str+="-\n";
				}
			}
		}
		if(res) {
			System.out.println(str);
		}
		
		
	}
}