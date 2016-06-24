package codility.numberocurrs;

class Solution {
    public int solution(int A, int B) {
        String Astr = Integer.toString(A);
        String Bstr = Integer.toString(B);
        int answ = 0;
        
        if(!Bstr.contains(Astr)){
            answ = -1;
        }
        else{
            answ = Bstr.indexOf(Astr);
        }
        
        
        return answ;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(0, 540000000));
    }
}