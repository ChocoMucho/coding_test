package ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q016 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		mData[] A = new mData[N];
		int max = 0;
		
		for(int i=0; i<N; i++) {
			A[i] = new mData(i, Integer.parseInt(br.readLine()));
		}
		Arrays.sort(A);
		
		
		for(int i=0; i<N; i++) {
			if(max<A[i].index-i)
				max = A[i].index-i;
		}
		System.out.println(max+1);
	}
	
}

class mData implements Comparable<mData>{
	int index;
	int value;
	
	public mData(int index, int value) {
		super();
		this.index = index;
		this.value = value;
	}
	
	@Override
	public int compareTo(mData o) {
		//비교하여 오름차순으로 sort 한다.
		return this.value - o.value;
	}
}