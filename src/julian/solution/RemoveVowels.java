package julian.solution;

public class RemoveVowels {

    public static void main(String[] args) {
        String response = new RemoveVowels().removeVowels("andres");
        System.out.print(response);
    }

    private String removeVowels(String str){
        int N = str.length();  // O(N)
        StringBuilder buffer = new StringBuilder();
        str = str.toLowerCase();

        for (int i=0; i<N; i++){
            if(str.charAt(i) != 'a' && str.charAt(i) != 'e' && str.charAt(i) != 'i' &&
                    str.charAt(i) != 'u' && str.charAt(i) != 'o'){
                buffer.append(str.charAt(i));
            }
        }
        return  buffer.toString();
        // Optimizing;
        // 1. count num vowels
        // 2. get indexes of those vowels
        // 3. Remove these indexes from buffer List<CharSeq>.
    }
}
