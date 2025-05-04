//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



//Back-end complete function Template for Java

class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
        if(arr.length < k)
        {
            return -1;
        }
        int low=max(arr),high=sum(arr);
        while(low<=high)
        {
            int mid=low + (high - low) /2;
            int Students = NumberOfStudents(arr,mid);
            if(Students > k)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return low;
    }
    public static int max(int[] arr)
    {
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            maxi=Math.max(maxi,arr[i]);
        }
        return maxi;
    }
    public static int sum(int[] arr)
    {
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
        }
        return sum;
    }
    public static int NumberOfStudents(int[] arr,int pages)
    {
        int student = 1,numberofpages=0;
        for(int i=0;i<arr.length;i++)
        {
            if(numberofpages + arr[i] <= pages)
            {
                numberofpages += arr[i];
            }
            else
            {
                student++;
                numberofpages = arr[i];
            }
        }
        return student;
    }
}