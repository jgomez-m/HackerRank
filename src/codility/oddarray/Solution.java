package codility.oddarray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Julian
 */
class Solution {

    public int solution(int[] A) {
        int freq = 0;
        List<Integer> intList = new ArrayList<>();
        for (int index = 0; index < A.length; index++) {
            intList.add(A[index]);
        }
        for (int n : A) {
            freq = Collections.frequency(intList, n);
            if (freq % 2 == 1) {
                return n;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int A[] = new int[]{9, 3, 9, 3, 9, 7, 9};
        System.err.println(s.solution(A));
    }
}
