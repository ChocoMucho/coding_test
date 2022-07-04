package ch03;
//백준 온라인 17298번
//오큰수(오른쪽큰수) 구하기
//오른쪽의 자기보다 큰 수들중 가장 왼쪽에 있는 수를 구한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class q012 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] A = new int[N]; //원본 배열
		int[] result = new int[N]; //정답 배열
		Stack<Integer> stack = new Stack<>();
		String str="";//출력 배열
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			//A[스택의 top]이 A[i]보다 작고 스택이 비어있지 않은 경우
			while(!stack.empty() && A[stack.peek()]<A[i] ) {
				//정답 배열의 스택top 인덱스 부분에 큰 수를 넣는다.
				result[stack.pop()] = A[i];
			}
			stack.push(i);//스택에 인덱스 값을 쌓음
		}
		while(!stack.empty()) {
			//스택에 남아있는 인덱스에 해당하는 정답 배열 부분에 -1을 넣는다.
			result[stack.pop()] = -1;
		}
		for(int i=0; i<N; i++) {
			str += result[i]+" ";
		}
		System.out.println(str);
	}
}
