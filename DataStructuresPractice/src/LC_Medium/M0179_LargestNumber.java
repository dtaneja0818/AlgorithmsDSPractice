package LC_Medium;
/**
 Time Complexity - O(n logn)
 Reason - Accessing all elements in one pass
 
 Space Complexity - O(n)
 Reason - String Array extra space
 */
import java.util.Arrays;
import java.util.Comparator;

public class M0179_LargestNumber {

    public String largestNumber(int[] nums) {
        if(nums== null || nums.length == 0)
            return "";

        // Convert int array to String array, so we can sort later on
        String[] s_num = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            s_num[i] = String.valueOf(nums[i]);

        // Comparator to decide which string should come first in concatenation
        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String str1, String str2){
                String s1 = str1 + str2; //102
                String s2 = str2 + str1; //210
                return s2.compareTo(s1); // reverse order here, so we can do append() later
            }
        };


        Arrays.sort(s_num, comp);
        // An extreme edge case by lc, say you have only a bunch of 0 in your int array
        if(s_num[0].charAt(0) == '0')
            return "0";


        StringBuilder sb = new StringBuilder();
        for(String s: s_num)
            sb.append(s);

        return sb.toString();
    }

    public static void main(String[] args) {
        M0179_LargestNumber cl = new M0179_LargestNumber();
        int[] s = {3,30,34,5,9};
        String res = cl.largestNumber(s);

        System.out.print(res);
    }
}
