import java.util.Arrays;

public class LongestConsecutiveSequence {
   public static void main(String[] args) {
    int[] array = {100, 4, 200, 1, 3, 2}; 

    longestConsecutive(array);
   }

   public static int longestConsecutive(int[] nums) {
        int z =0;
        Arrays.sort(nums);

        for (int i=0 ; i < nums.length-1; i++) {
            if ((nums[i+1] - nums[i])==1 || (nums[i+1] - nums[i])==0){
                z++;
                
            }
            else if ((nums[i+1] - nums[i])>1){
                return z+1;
            }
            
            else{
                return z;
            }
        }
        System.out.println(z);
        return z;
        
    }

}



class Solution {
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);

        int best = 1;
        int streak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                // duplike: atla
                continue;
            } else if (nums[i] == nums[i - 1] + 1) {
                streak++;
            } else {
                streak = 1;
            }
            best = Math.max(best, streak);
        }
        return best;
    }
}