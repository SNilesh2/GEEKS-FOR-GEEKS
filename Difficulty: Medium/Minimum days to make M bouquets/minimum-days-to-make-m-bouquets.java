//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
       
        int t = sc.nextInt();
        while(t-- > 0){
            
            
           int M = sc.nextInt();
           int K = sc.nextInt();
            
            
            //int n = sc.nextInt();
            sc.nextLine();
            String s[]=sc.nextLine().split(" ");
            int n=s.length;
            int[] bloomDay = new int[n];
            for(int i=0;i<n;i++) bloomDay[i]=Integer.parseInt(s[i]);
            
            Solution obj = new Solution();
            int res = obj.solve(M, K, bloomDay);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int solve(int M, int K, int[] bloomDay) {
        long val=(long)M*(long)K;
        if(val>bloomDay.length) return -1;
        int mini=Integer.MAX_VALUE;
        int n=bloomDay.length;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            mini=Math.min(mini,bloomDay[i]);
            maxi=Math.max(maxi,bloomDay[i]);
        }
        int low=mini,high=maxi;
        int ans=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(possible(bloomDay,mid,M,K))
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
    public static boolean possible(int[] bloomDay,int mid,int m,int k)
    {
        int count=0,noofbouquets=0;
        for(int i=0;i<bloomDay.length;i++)
        {
            if(bloomDay[i]<=mid)
            {
                count++;
            }
            else
            {
                noofbouquets+=(count/k);
                count=0;
            }
        }
        noofbouquets+=(count/k);
        return noofbouquets>=m;
    }
}