package ch03;
import java.util.Scanner;
//백준 온라인 2018번
//연속된 자연수의 합 구하기(투 포인터)
//15입력 => (1,2,3,4,5) (4,5,6) (7,8) (15) => 4
public class q006 {
	public static void main(String[] args) {
		System.out.println("숫자를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		//두개의 포인터를 움직이며 합을 구해본다.
		int si = 1;
		int ei = 1;
		int count = 1;
		int sum = 1;
		
		while(ei != N) {
			if(sum==N){//합과 입력 값이 같을 때
				ei++;
				sum+=ei;//끝점을 1증가 시키고 값을 누적한다.
				count++;
			}else if(sum>N){//합이 입력값 보다 클 때
				sum-=si;//시작점 만큼의 값을 누적합에서 잘라내고
				si++;//시작점을 1증가시킨다.
			}else{//합이 입력 값보다 작을 때
				ei++;
				sum+=ei;//끝점을 1증가시키고 값을 누적한다.
			}
		}
		System.out.println(count);
	}
}
