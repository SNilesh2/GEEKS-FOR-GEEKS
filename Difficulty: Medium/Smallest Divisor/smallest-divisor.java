//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int K;
            K = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.smallestDivisor(nums, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int smallestDivisor(int[] nums, int K) {
        if(nums.length>K) return -1;
        int maxi=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            maxi=Math.max(maxi,nums[i]);
        }
        int low=1,high=maxi;
        int ans=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int sum=divisor(nums,K,mid);
            if(sum<=K)
            {
                ans=Math.min(ans,mid);
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
    public static int divisor(int[] nums,int threshold,int mid)
    {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=Math.ceil((double)nums[i]/(double)mid);
        }
        return sum;
    }
}