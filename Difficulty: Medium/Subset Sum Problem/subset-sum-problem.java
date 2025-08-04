class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int[][] dp=new int[arr.length][sum+1];
        for(int[] a : dp)
        {
            Arrays.fill(a,-1);
        }
        return (findTarget(arr.length-1,sum,arr,dp)==1 )? true : false;
    }
    public static int findTarget(int i,int target,int[] nums,int[][] dp)
    {
        if(target==0)
        {
            return 1;
        }
        if(i==0)
        {
            return (nums[0]==target) ? 1 : 0;
        }
        if(dp[i][target]!=-1)
        {
            return dp[i][target];
        }
        int notTake = findTarget(i-1,target,nums,dp);
        int take = 0;
        if(nums[i]<=target)
        {
            take = findTarget(i-1,target-nums[i],nums,dp);
        }
        return dp[i][target] = ((take | notTake)==1) ? 1 : 0 ; 
    }
}