package codility.zeroindexedarray;

class Solution {
    public int solution(int[] A) {
        final int size = A.length;
        long sumMin = (long)A[0];
        long sumMax = 0;
        for (int i = 1; i < size; i++) {
            sumMax += (long)A[i];
        }
        int minDif = (int)Math.abs(sumMax - sumMin);
        for (int i = 1; i < size; i++) {
            int dif = (int)Math.abs(sumMax - sumMin);
            if (dif < minDif) {
                minDif = dif;
            }
            sumMin += A[i];
            sumMax -= A[i];
        }
        return minDif;
    }

}