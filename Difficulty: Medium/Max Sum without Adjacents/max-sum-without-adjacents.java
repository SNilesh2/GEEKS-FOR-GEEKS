//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
        // code here
        return solve(arr.length,arr);
    }
    public static int solve(int n,int[] nums)
    {
        int prev1=nums[0];
        int prev2=0;
        for(int ind=1;ind<n;ind++)
        {
            int pick=nums[ind];
            if(ind>1) pick=pick+prev2;
            int notpick=0+prev1;
            int curri=Math.max(pick,notpick);
            prev2=prev1;
            prev1=curri;
        }
        return prev1;
    }
}