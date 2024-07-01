//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
         if(s.length()==0 || p.length()==0 || s==null || p==null)
        {
            return "";
        }
        Map<Character,Integer> pfreq=new HashMap<>();
        for(char c:p.toCharArray())
        {
            pfreq.put(c,pfreq.getOrDefault(c,0)+1);
        }
        int required=pfreq.size();
        int formed=0;
        int left=0,right=0;
        int[] ans={-1,0,0};
        Map<Character,Integer> windowfreq=new HashMap<>();
        while(right<s.length())
        {
            char c=s.charAt(right);
            windowfreq.put(c,windowfreq.getOrDefault(c,0)+1);
            if(pfreq.containsKey(c) && windowfreq.get(c).intValue()==pfreq.get(c).intValue())
            {
                formed++;
            }
            while(left<=right && formed==required)
            {
                c=s.charAt(left);
                if(ans[0]==-1 || right-left+1<ans[0])
                {
                    ans[0]=right-left+1;
                    ans[1]=left;
                    ans[2]=right;
                }
                windowfreq.put(c,windowfreq.get(c)-1);
                if(pfreq.containsKey(c) && windowfreq.get(c).intValue()<pfreq.get(c).intValue())
                {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return ans[0]==-1 ? "-1":s.substring(ans[1],ans[2]+1);
    }
}