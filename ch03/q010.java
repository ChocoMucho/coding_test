package ch03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class q010 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//결과를 버퍼에 넣고 한 번에 출력하기 위해 BufferedWriter
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//데이터 개수
		int L = Integer.parseInt(st.nextToken());//범위
		int now = 0;//하나 씩 추가 될 숫자
		
		Deque<Node> mydeque = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			now = Integer.parseInt(st.nextToken());//하나 씩 추가 될 숫자
			
			//덱이 비어있지 않고, 추가된 숫자가 덱의 마지막 값보다 작을 경우.
			while(!mydeque.isEmpty() && mydeque.getLast().value > now) {
				//덱에서 제외 해버림으로써 최소 값이 아닌 숫자를 걸러낸다.
				mydeque.removeLast();
			}
			
			//추가 된 숫자를 덱 마지막에 추가한다.
			mydeque.addLast(new Node(i, now));
			
			//덱 첫번째의 인덱스 값이 범위(변수L)를 벗어날 경우
			if(mydeque.getFirst().index <= i-L) {
				//덱에서 제외한다.
				mydeque.removeFirst();
			}
			//덱 첫번째(최소값)
			bw.write(mydeque.getFirst().value + " ");//버퍼에 덱의 첫 번째 값을 넣는다.
		}
		bw.flush();
		bw.close();
	}
	
	static class Node {//인덱스와 값의 형태인 노드 구현
		public int index;
		public int value;
		
		Node(int index, int value){
			this.index = index; 
			this.value = value;
			
		}
	}
}
