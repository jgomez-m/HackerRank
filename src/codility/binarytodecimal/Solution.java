package codility.binarytodecimal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Julian
 */
public class Solution {
       
    public int[] solution(int[] A) {
        double radix = -2.0;
        int value = fromBinaryToInt(A, radix);
        return fromIntToBinary(-value, radix);
    }
    
     private int fromBinaryToInt(int B[], double radix) {
        int ret = 0;
        for (int i=0; i<B.length; i++) {
            double pow = Math.pow(radix, i*1.0);
            int j = (int) (B[i]*pow);
            ret += j;
        }
        return ret;
    }
    
    private int[] fromIntToBinary(int value, double radix) {
        List<Integer> list = new ArrayList<>();
        while(value!=0) {
            int div = (int) Math.ceil(value / radix);
            int remainder = value % (int)radix;
            value = div;
            list.add(Math.abs(remainder));
        }
        int[] ret = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
    
    public static void main(String args[]){
        Solution s = new Solution();
        int A[] = new int[] {1,0,0,1,1,1};
        System.out.println(Arrays.toString(s.solution(A)));
    }
}
