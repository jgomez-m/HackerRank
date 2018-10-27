package codility.singleswap;

import java.util.*;

/**
 * Sort an integer array in non-decreasing order with single swap
 * @author Julian Gomez
 *
 */

public class Solution {
	public boolean solution(int[] A) {
		int count = 0;
		if (A.length <= 2){
			return true;
		}
		
	    int B[] = Arrays.copyOf(A, A.length); 
	    Arrays.sort(B);     
	    for(int i=0; i<A.length; i++)
	    {
	        if(A[i] != B[i])
	        	count++;
	    }
	
	    if(count > 2){
	    	return false;
	    }
	    return true;
	}
}
