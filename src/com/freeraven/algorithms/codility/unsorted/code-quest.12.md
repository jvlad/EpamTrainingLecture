Write a function:

class Solution { public int solution(int A, int B, int K); }

that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

{ i : A ≤ i ≤ B, i mod K = 0 }

For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

Assume that:

A and B are integers within the range [0..2,000,000,000];
K is an integer within the range [1..2,000,000,000];
A ≤ B.
Complexity:

expected worst-case time complexity is O(1);
expected worst-case space complexity is O(1).

```
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    private int A;
    private int B;
    private int K;
    public int solution(int A, int B, int K) {
        this.A = A;
        this.B = B;
        this.K = K;
        // write your code in Java SE 8
        int minDivisibleInRange = calculateMinDivisibleInRange();
        int maxDivisibleInRange = calculateMaxDivisibleInRange();
        
        if(minDivisibleInRange == -1){
            return 0;
        }
        
        if(minDivisibleInRange == maxDivisibleInRange){
            return 1;    
        }
        
        return (maxDivisibleInRange - minDivisibleInRange) / K + 1;
    }
    
    private int calculateMinDivisibleInRange() {
        int remainder = A % K;
        
        if(remainder == 0){
            return A;
        } 
        
        int suspected = A + K - remainder;
        
        if(suspected <= B){
            return suspected;    
        } else {
            return -1;    
        }
    }
    
    private int calculateMaxDivisibleInRange(){
        int remainder = B % K;
        
        if(remainder == 0){
            return B;
        }
        
        return (B - remainder);
    }
}
```