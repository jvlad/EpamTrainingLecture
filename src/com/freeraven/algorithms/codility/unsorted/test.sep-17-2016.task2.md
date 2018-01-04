// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        if (A.length == 1){
            if (A[0] != 1){
                return 0;
            } else {
                return 1;    
            }
        }
        
        int numberOfPrefixPermutations = 0;
        
        ArrayList<Integer> subArray = new ArrayList<>();
        for (int i = 0; i < A.length; i++){
            subArray.add(A[i]);
            if (isPermutation(subArray)){
                numberOfPrefixPermutations++;    
            }
        }
        return numberOfPrefixPermutations;
    }
    
    private boolean isPermutation(ArrayList<Integer> array){
        for (int element : array){
            if (element > array.size()){
                return false;        
            }
        }
        return true;
    }
}