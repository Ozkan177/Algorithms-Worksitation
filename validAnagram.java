import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {

        String[] str1 = s.split("");
        String[] str2 = t.split("");

        Arrays.sort(str1);
        Arrays.sort(str2);
        if(s.length()<2&&s.equals(t)){
            return true;
        }
        if(!s.equals(t)){
            return Arrays.equals(str1, str2);
        }
        return false;

    }
}
