//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];

            int D = Integer.parseInt(read.readLine());

            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr, N, D));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int leastWeightCapacity(int[] arr, int n, int d) {
        // code here
        int maxi=Integer.MIN_VALUE,sum=0;
        for(int i=0;i<n;i++)
        {
            maxi=Math.max(maxi,arr[i]);
            sum+=arr[i];
        }
        int low=maxi,high=sum;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int noofdays=finddays(arr,mid);
            if(noofdays<=d)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;
    }
    public static int finddays(int[] weights,int cap)
    {
        int day=1,load=0;
        for(int i=0;i<weights.length;i++)
        {
            if(load+weights[i]>cap)
            {
                day+=1;
                load=weights[i];
            }
            else
            {
                load+=weights[i];
            }
        }
        return day;
    }
};