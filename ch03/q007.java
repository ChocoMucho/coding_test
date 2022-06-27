package ch03;
//백준 온라인 1940번
//투 포인터 예시 문제
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q007 {
	public static void main(String[] args)throws IOException{
		System.out.println("입력할 수의 [개수]와 두 수를 합쳐 [만들 수]를 입력하세요");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int A[] = new int[N];
		int i = 0;
		int j = N-1;
		int count = 0;
		
		System.out.println("개수에 맞춰 수 들을 입력하세요");
		st = new StringTokenizer(bf.readLine());
		for(int x=0; x<N; x++) {
			A[x] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		
		while(i<j)
		{
			if(A[i]+A[j]>M) {
				j--;
			}else if(A[i]+A[j]<M) {
				i++;
			}else {
				i++;
				j--;
				count++;
			}
		}
		System.out.println(count);
	}
}
