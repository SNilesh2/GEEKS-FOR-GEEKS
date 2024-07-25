//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minimumEnergy(int arr[],int N){
        //code here
        int[] dp=new int[N];
        Arrays.fill(dp,-1);
        return fun(N-1,arr,dp);
    }
    public static int fun(int ind,int[] arr,int[] dp)
    {
        if(ind==0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int secondstep=Integer.MAX_VALUE;
        int firststep=fun(ind-1,arr,dp)+Math.abs(arr[ind]-arr[ind-1]);
        if(ind>1)
        {
            secondstep=fun(ind-2,arr,dp)+Math.abs(arr[ind]-arr[ind-2]);
        }
        return dp[ind]=Math.min(firststep,secondstep);
    }
}