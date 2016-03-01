package codility.splitarray;


/**
 *
 * @author Julian
 */
public class Solution {

    public int solution(int X, int[] A) {
        int leftSame = 0;
        int rightSame = 0;
        int leftDiff = 0;
        int rightDiff = 0;
        int index = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == X) {
                leftSame += 1;
            } else {
                leftDiff += 1;
            }

            if (i > ((A.length - 1) - i)) {
                break;
            }

            if (A[(A.length - 1) - i] == X) {
                rightSame += 1;
            } else {
                rightDiff += 1;
            }

            if (leftSame == rightDiff) {
                index = i;
            }

            if (leftDiff == rightSame) {
                index = A.length - 1 - i;
            }

        }
        return index;
    }
}
