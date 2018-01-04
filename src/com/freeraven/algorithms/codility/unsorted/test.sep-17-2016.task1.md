// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int A, int B) {
        // write your code in Java SE 8
        if (B < 0){
            return 0;    
        }
        int numberOfWholeSquares = 0;
        int startFrom = 0;
        if (A > 0) {
            startFrom = A;    
        }
        for (int i = startFrom; i <= B; i++){
            int square = (int) Math.sqrt(i);
            if (square * square == i){
                numberOfWholeSquares++;    
            }
        }
        return numberOfWholeSquares;
    }
}