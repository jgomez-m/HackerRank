package codility.binarygap;


class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        String binaryNumber = Integer.toBinaryString(N);
        return longestBinaryGap(binaryNumber);
    }

    private int longestBinaryGap(String binaryNumber){
        char[] array =  binaryNumber.toCharArray();
        int longestGap = 0;
        for(int i=0; i<array.length-1; i++)
        {
            int count = 0;
            boolean gapValid = false;
            if(array[i+1] == '0')
            {
                for (int j = i+1; j < array.length; j++)
                {
                    if(array[j] == '0')
                    {
                        count++;
                    }
                    else{
                        i = j-1;
                        gapValid = true;
                        break;
                    }
                }
                longestGap = longestGap<count && gapValid? count: longestGap;
            }
        }
        return longestGap;
    }
}
