import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> seen = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int need = target-numbers[i];
            if(seen.containsKey(need)){
                return new int[]{seen.get(need),(i+1)};
            }
            seen.put(numbers[i],(i+1));
        }
        throw new IllegalArgumentException("No solution");   
        
    }
}