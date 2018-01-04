A non-empty zero-indexed array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.

For example, in array A such that:

  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the elements at indexes 0 and 2 have value 9,
the elements at indexes 1 and 3 have value 3,
the elements at indexes 4 and 6 have value 9,
the element at index 5 has value 7 and is unpaired.
Write a function:

class Solution { public int solution(int[] A); }
that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.

For example, given array A such that:

  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the function should return 7, as explained in the example above.

Assume that:

N is an odd integer within the range [1..1,000,000];
each element of array A is an integer within the range [1..1,000,000,000];
all but one of the values in A occur an even number of times.
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        if (A.length == 1){
            return A[0];
        }
        
        int maxElement = findMaxElement(A);
        int[] countersArray = new int[maxElement + 1];
        for (int i = 0; i < A.length; i++){
            countersArray[A[i]] += 1;    
        }
        
        for (int i = 0; i < countersArray.length; i++){
            if(countersArray[i] % 2 != 0){
                return i;
            }    
        }
        
        return A[0];
    }
    
    public int findMaxElement(int[] A){
        int max = 0;
        for (int i = 0; i < A.length; i++){
            if(A[i] > max){
                max = A[i];
            }    
        }
        return max;
    }
}

100% solution:
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    private HashMap<Integer, Boolean> map;
    
    public int solution(int[] A) {
        // write your code in Java SE 8
        int suspected = A[0];
        map = new HashMap<>();
        
        for(int i = 0; i < A.length; i++){
            toggleMapEntry(A[i]);
        }
        
        Set<Map.Entry<Integer,Boolean>> entries = map.entrySet();
        for(Map.Entry<Integer,Boolean> entry : entries){
            if(entry.getValue()){
                return entry.getKey();    
            }
        }
        
        return suspected;
    }
    
    private void toggleMapEntry(int key){
        Boolean result = map.get(key);
        if(result == null || !result){
            map.put(key, true);
        } else {
            map.put(key, false);
        }
    }
}