package ch03;
//구간 합 2차원 배열 문제

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q004 {
	public static void main(String[] args)throws IOException {
		System.out.println("배열의 크기와 질의 개수를 입력하세요");
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(buffer.readLine());
		
		int N = Integer.parseInt(token.nextToken());//2차원 배열 크기
		int Q = Integer.parseInt(token.nextToken());//질의 개수
		
		int A[][] = new int[N+1][N+1];
		int D[][] = new int[N+1][N+1];
		
		//원본 배열 입력 받기
		for(int i=1; i<=N; i++) {
			System.out.println("원본 배열 " + i + "째 줄 입력");
			token = new StringTokenizer(buffer.readLine());// 배열의 행 값 받음
			for(int j=1; j<=N; j++) {
				A[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		
		//구간 합 배열 입력
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				D[i][j] = A[i][j] + D[i-1][j] + D[i][j-1] - D[i-1][j-1];
			}
		}
		
		//질의 및 결과 출력
		System.out.println("구간 (X1,Y1) (X2,Y2) 정수 4개를 띄어 입력하세요");
		for(int i=0; i<Q; i++) {
			token = new StringTokenizer(buffer.readLine());//질의 정수 4개 입력
			int x1 = Integer.parseInt(token.nextToken());
			int y1 = Integer.parseInt(token.nextToken());
			int x2 = Integer.parseInt(token.nextToken());
			int y2 = Integer.parseInt(token.nextToken());
			int result = 0;
			result = D[x2][y2] - D[x2][y1-1] - D[x1-1][y2] + D[x1-1][y1-1];
			
			System.out.println(result);
			
			
		}
	}
}
