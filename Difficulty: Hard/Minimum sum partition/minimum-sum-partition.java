// User function Template for Java

class Solution {

    public int minDifference(int arr[]) {
        // Your code goes here
        int totalSum=0;
        for(int i=0;i<arr.length;i++)
        {
            totalSum =totalSum + arr[i];
        }
        
        int[][] dp=new int[arr.length][totalSum+1];
        for(int[] num : dp)
        {
            Arrays.fill(num,-1);
        }
        return findCount(arr.length-1,0,totalSum,arr,dp);
    }
    public static int findCount(int ind,int sum,int totalSum,int[] nums,int[][] dp)
    {
        if(ind<0)
        {
            int other = totalSum - sum;
            return Math.abs(sum - other);
        }
        if(dp[ind][sum]!=-1)
        {
            return dp[ind][sum];
        }
        int notTake = findCount(ind-1,sum,totalSum,nums,dp);
        int take = findCount(ind-1,sum + nums[ind],totalSum,nums,dp);
        return dp[ind][sum] = Math.min(take,notTake);
    }
}
