package ch03;
//백준 온라인 12891번
//슬라이딩 윈도우

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q009 {
	static int myArr[] = new int[4];//내 비밀번호의 상태 배열
	static int checkArr[] = new int[4];//비밀번호 체크 배열. A는 몇개 C는 몇개 정하는 배열
	static int checkSecret = 0;//4라면 조건 일치 
	
	public static void main(String[] args)throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		//입력 1
		int S = Integer.parseInt(st.nextToken());//전체 문자열 길이
		int P = Integer.parseInt(st.nextToken());//부분 문자열 길이
		int result = 0;
		
		//입력 2
		//원본 배열
		char Arr[] = new char[S];
		Arr = bf.readLine().toCharArray();
		
		//입력 3
		//체크 배열
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			if(checkArr[i]==0) {//포함돼야할 수가 없으면 1을 더한다. 
				checkSecret++;
			}
		}
		
		for(int i=0; i<P; i++) {//P-1까지 체크
			Add(Arr[i]);
		}
		
		if(checkSecret == 4) {
			result++;
		}
		
		for(int i=P; i<S; i++) {
			int j = i-P;//0부터 가능한 수까지
			Add(Arr[i]);//엔드포인트, P부터
			Remove(Arr[j]);//스타트포인트,0부터
			if(checkSecret == 4) {
				result++;
			}
		}
		System.out.println(result);
	}
	
	private static void Add(char a) {	
		char c = a;
		
		switch(c) {
			case 'A':
				//현재 배열 상태의 값을 1증가시키고, 
				//값이 체크 배열과 동일하면 checkSecret 1증가
				myArr[0]++;
				if(myArr[0]==checkArr[0]) checkSecret++;
				break;
			case 'C':
				myArr[1]++;
				if(myArr[1]==checkArr[1]) checkSecret++;
				break;
			case 'G':
				myArr[2]++;
				if(myArr[2]==checkArr[2]) checkSecret++;
				break;
			case 'T':
				myArr[3]++;
				if(myArr[3]==checkArr[3]) checkSecret++;
				break;
		}
	}
	
	private static void Remove(char r) {
		char c = r;
		
		switch(c) {
			case 'A':
				//현재 배열 상태와 체크 배열의 값이 같으면 1감소하고
				//현재 배열 상태의 값을 1감소
				if(myArr[0]==checkArr[0]) checkSecret--;
				myArr[0]--;
				break;
			case 'C':
				if(myArr[1]==checkArr[1]) checkSecret--;
				myArr[1]--;
				break;
			case 'G':
				if(myArr[2]==checkArr[2]) checkSecret--;
				myArr[2]--;
				break;
			case 'T':
				if(myArr[3]==checkArr[3]) checkSecret--;
				myArr[3]--;
				break;
		}
	}
}
