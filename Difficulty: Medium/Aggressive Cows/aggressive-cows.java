//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int n=stalls.length;
        int low=1,high=stalls[n-1]-stalls[0];
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(canweplace(stalls,mid,k)==false)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return high;
    }
    public static boolean canweplace(int[] stalls,int dist,int cows)
    {
        int cntcows=1,last=stalls[0];
        for(int i=1;i<stalls.length;i++)
        {
            if(stalls[i]-last>=dist)
            {
                cntcows++;
                last=stalls[i];
            }
            if(cntcows>=cows)
            {
                return true;
            }
        }
        return false;
    }
}