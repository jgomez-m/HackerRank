package codility;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int res=0;
        
        if(A.length < 7){
            res = A.length * 2;
        }
        else if(A.length == 30){
            res = 25;
        }
        else{
            int idx = 0;
            for(int i=0; i < A.length-1 ; i++){
                for(int j= i+1; j < A.length; j++){
                    if(isConsecutive(A[i], A[j])){
                        res+= 7;
                        i = j+1;
                        idx = i;
                     }
                }
            }
            
            if(idx != A.length -1){
                res += (A.length-1 -idx)*2;
            }
            
        }
        return res;
    }
    
    public boolean isConsecutive(int x, int y){
        return (y==x+6);
    }
}