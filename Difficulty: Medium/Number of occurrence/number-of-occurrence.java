//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        ArrayList<Integer> count=new ArrayList<>();
        count=find(arr,n,x);
        if(count.get(0)==-1) return 0;
        return count.get(1)-count.get(0)+1;
    }
     ArrayList<Integer> find(int arr[], int n, int x)
    {
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        int first=firstoccurence(arr,x);
        if(first==-1) {
            res.add(-1);
            res.add(-1);
            return res;
        }
        int last=lastoccurence(arr,x);
        res.add(first);
        res.add(last);
        return res;
    }
    public static int firstoccurence(int[] nums, int target)
    {
        int low=0,high=nums.length-1;
        int ans=-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(nums[mid]==target)
            {
                ans=mid;
                high=mid-1;
            }
            else if(nums[mid]<target) low=mid+1;
            else high=mid-1;
        }
        return ans;
    }
    public static int lastoccurence(int[] nums, int target)
    {
        int low=0,high=nums.length-1;
        int ans=-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(nums[mid]==target)
            {
                ans=mid;
                low=mid+1;
            }
            else if(nums[mid]<target) low=mid+1;
            else high=mid-1;
        }
        return ans;
    }
}