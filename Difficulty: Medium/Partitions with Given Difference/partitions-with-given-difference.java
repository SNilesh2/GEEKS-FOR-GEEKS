
class Solution {
    int countPartitions(int[] arr, int d) {
        // code here
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            sum=sum+arr[i];
        }
        if((d + sum )% 2 !=0)
        {
            return 0;
        }
        int target = (d + sum)/2;
        int[][] dp=new int[arr.length][target+1];
        for(int[] nums : dp)
        {
            Arrays.fill(nums,-1);
        }
        return findCount(arr.length-1,target,arr,dp);
    }
    public static int findCount(int ind,int target,int[] nums,int[][] dp)
    {
        if(ind==0)
        {
            if(nums[0]==0 && target==0)
            {
                return 2;
            }
            else if(target==0 || nums[0]==target)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        if(dp[ind][target]!=-1)
        {
            return dp[ind][target];
        }
        int notPick = findCount(ind-1,target,nums,dp);
        int pick=0;
        if(nums[ind]<=target)
        {
            pick = findCount(ind-1,target - nums[ind],nums,dp);
        }
        return dp[ind][target] = pick + notPick;
    }
} 
