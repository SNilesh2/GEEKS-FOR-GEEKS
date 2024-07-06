//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int h = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int Solve(int N, int[] piles, int H) {
        // code here
        int low=1,high=max(piles);
        int ans=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int totalhours=findtotalhours(piles,mid);
            if(totalhours<=H)
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
    public static int max(int[] piles)
    {
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++)
        {
            maxi=Math.max(maxi,piles[i]);
        }
        return maxi;
    }
    public static int findtotalhours(int[] piles,int mid)
    {
        int totalhours=0;
        for(int i=0;i<piles.length;i++)
        {
            totalhours+=Math.ceil((double)piles[i]/(double)mid);
        }
        return totalhours;
    }
}
        
