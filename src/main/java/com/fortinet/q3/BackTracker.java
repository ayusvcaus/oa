package com.fortinet.q3;

import java.util.List;

public class BackTracker {
	
	/*
	 * Reference: https://www.quora.com/How-can-I-divide-an-array-consisting-of-N-positive-integers-including-zero-into-K-subsets-such-that-the-sum-of-elements-of-each-subset-is-the-same
	 */
    
	public static boolean fill(List<Integer> list, int gSum, int n, boolean[] take) {
		
		if (gSum==0) {
			return true;
		}
		if (n==0) {
			return false;
		}

		if (fill(list, gSum, n-1,take)) {
			return true;
		} else if (!take[n-1]) {
			if (fill(list, gSum-list.get(n-1), n-1, take)) {
				take[n-1] = true;
				return true;
			}
		}
		return false;
	}
    
    /*
     * Time complexity O(k*n^n) worst case, it's hard to estimate
     * Space comlexity O(n) Ignore then size of array of boolean : "take" 
     *                      since the size of boolean (around 1 byte, but use 1 bit only) are smaller than int (4 bytes)
	 */
    
	public static boolean isSeparable(List<Integer> list, int k) {

		if (k<=0) {
			return false;
		}
		if (k==1){
			return true;
		}
		if (list==null) {
			return false;
		}
		int n = list.size();
		if (n<k) {
			return false;
		} 

		int sum = 0;
		for (int i=0; i<n; i++) {
			sum += list.get(i);
		}
		
		if (sum%k!=0) {
			return false;
		}
		int gSum = sum/k;
		boolean[] take=new boolean[n];
		while (--k>0 && fill(list, gSum, n, take));
        return k==0;
	}
}

