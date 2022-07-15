package ch03;

import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q014 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) ->{
			//큐를 순회하며 비교할 대상인 매개변수 2개 o1, o2
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);
			if(abs1 == abs2)//비교값들의 절대값이 같을 경우
				//비교값 원본을 비교하여 무엇이 더 큰지 판단 후 리턴
				return o1 > o2 ? 1 : -1;
			else
				//양수 -> 첫번째 매개변수가 더 큰 것으로 판단
				//0 -> 같은 값
				//음수 -> 첫번째 매개변수가 더 작은 것으로 판단
				return abs1 - abs2;
		});
		
		for(int i=0; i<N; i++) {
			int request = Integer.parseInt(br.readLine());
			if(request == 0) {//입력이 0일 때
				if(queue.isEmpty()) System.out.println("0");
				else System.out.println(queue.poll());
			} 
			else {
				queue.add(request);
			}
		}
	}
}
