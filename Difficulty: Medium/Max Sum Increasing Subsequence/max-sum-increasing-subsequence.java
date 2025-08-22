// User function Template for Java

class Solution {
    public int maxSumIS(int arr[]) {
        // code here.
        int[][] dp=new int[arr.length][arr.length+1];
        for(int[] ar : dp)
        {
            Arrays.fill(ar,-1);
        }
        return findMaximum(0,-1,arr,dp);
    }
    public static int findMaximum(int ind,int prev_ind,int[] arr,int[][] dp)
    {
        if(ind==arr.length)
        {
            return 0;
        }
        if(dp[ind][prev_ind+1]!=-1)
        {
            return dp[ind][prev_ind+1];
        }
        int notTake = findMaximum(ind+1,prev_ind,arr,dp);
        int take = 0;
        if(prev_ind==-1 || arr[prev_ind]<arr[ind])
        {
            take = arr[ind] + findMaximum(ind+1,ind,arr,dp);
        }
        return dp[ind][prev_ind+1] = Math.max(take,notTake);
    }
}