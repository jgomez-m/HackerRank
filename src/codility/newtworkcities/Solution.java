package codility.newtworkcities;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] T) {
        // write your code in Java SE 8
        int [] res = new int[T.length];
        int capitalIndex = findCapital(T);

        return res;
    }

    private static int findCapital(int[] array) {
        int i=0;
        int res = -1;
        for(; i<array.length; i++){
            if(array[i] == i){
                res = i;
            }
        }
        return res;
    }

    private static int numberOfDirectPaths(int x, int array[]){
        int count = 0;
        for(int i= 0; i<array.length; i++) {
            if (array[i] == x && x != i) {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        int[] array = {9, 1, 4, 9, 8, 4, 8, 9, 0, 1};
        System.out.println("This is the Capital: " + findCapital(array));
        System.out.println("Number of Direct Paths From Capital: "+ numberOfDirectPaths(findCapital(array), array));
    }
}