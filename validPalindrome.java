public class validPalindrome {
    
}

class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[\\p{Punct}\\s]", "");
        s=s.toLowerCase();

        int z=s.length();

        if(z==0||z==1) return true;
        
        for (int j = 0; j < z/2; j++) {
            if(s.charAt(j)!=s.charAt(z-1-j)){
                
                return false;
            }
        }
        return true;

    }
}