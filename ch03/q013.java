package ch03;
//백준온라인 2164번
//카드게임

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class q013 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		
		//큐에 남은 요소가 1개일 때까지
		//front에서 요소를 없애고
		//rear에 front값을 add한다.
		while(queue.size()>1) {
			queue.poll();
			queue.add(queue.poll());
		}
		
		//마지막 남은 것을 출력
		System.out.println(queue.peek());
	}
}
