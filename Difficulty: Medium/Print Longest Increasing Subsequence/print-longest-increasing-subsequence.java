// User function Template for Java

class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {
        // Code here
        int[] dp=new int[arr.length];
        int[] hash=new int[arr.length];
        ArrayList<Integer> result=new ArrayList<>();
        int n=arr.length;
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++)
        {
            hash[i]=i;
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[j]<arr[i] && dp[i] < 1+dp[j])
                {
                    dp[i]=1+dp[j];
                    hash[i]=j;
                }
            }
        }
        int maxi=Integer.MIN_VALUE;
        int ind=-1;
        for(int i=0;i<n;i++)
        {
            if(dp[i]>maxi)
            {
                maxi=dp[i];
                ind=i;
            }
        }
        result.add(arr[ind]);
        while(ind!=hash[ind])
        {
            result.add(arr[hash[ind]]);
            ind=hash[ind];
        }
        Collections.reverse(result);
       /* for(int i=0;i<n;i++)
        {
            System.out.println(dp[i]);
        } */
        return result;
    }
}
