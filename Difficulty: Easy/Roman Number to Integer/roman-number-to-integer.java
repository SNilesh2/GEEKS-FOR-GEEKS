//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) {
        // code here
        Map<Character,Integer> romanvalues=new HashMap<>();
        romanvalues.put('I',1);
        romanvalues.put('V',5);
        romanvalues.put('X',10);
        romanvalues.put('L',50);
        romanvalues.put('C',100);
        romanvalues.put('D',500);
        romanvalues.put('M',1000);
        int total=0;
        int prevvalue=0;
        for(int i=str.length()-1;i>=0;i--)
        {
            int currentvalue=romanvalues.get(str.charAt(i));
            if(currentvalue<prevvalue)
            {
                total=total-currentvalue;
            }
            else
            {
                total=total+currentvalue;
            }
            prevvalue=currentvalue;
        }
        return total;
    }
}