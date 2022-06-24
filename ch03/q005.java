package ch03;

//백준 온라인 10986번
//나머지 합 구하기
//N개 정수, 나눌 숫자 M
//M으로 나눈 구간의 합이 딱 나누어 떨어지는 경우의 수 구하기.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q005 {
	public static void main(String[] args)throws IOException {
		System.out.println("나머지 합 문제입니다.");
		System.out.println("개수와 나눌 수를 입력하세요");
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long answer = 0; 
		
		long S[] = new long[N];
		long C[] = new long[M];
		
		System.out.println("개수에 맞는 정수를 입력하세요"+N);
		st = new StringTokenizer(bf.readLine());
				
		S[0] = Long.parseLong(st.nextToken());
		
		for(int i=1; i<N; i++) {
			S[i] = S[i-1] + Long.parseLong(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {//배열 S의 요소들을 나누고, 각각의 나머지에 따른 개수 저장
			int remain = (int) (S[i] % M);
			if(remain==0) answer++;
			C[remain]++;			
		}
		
		for(int i=0; i<M; i++) {
			if(C[i]>1) {
				answer = answer + (C[i] * (C[i]-1) / 2);//C[i]개 중에서 2가지 뽑기(nCr) => n*(n-1)/r*(r-1)
			}
		}
		
		System.out.println("연속된 부분의 합이 나누어 떨어지는 구간 개수 : "+answer);
	}
}