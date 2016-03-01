package codility.zeroindexedarray;

class Solution {

    public int solution(int A[]) {
        int n = A.length;
        if (n == 0) {
            return -1;
        }
        long sum = 0;
        int i;
        for (i = 0; i < n; i++) sum += (long) A[i];
        long sum_left = 0;
        for (i = 0; i < n; i++) {
            long sum_right = sum - sum_left - (long) A[i];
            
            if (sum_left == sum_right) {
                return i;
            }
            sum_left += (long) A[i];
        }
        return -1;
    }

}
