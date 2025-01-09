//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input (arr)
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] =
                    Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input (dep)
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] dep = new int[m];
            for (int i = 0; i < m; i++) {
                dep[i] =
                    Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            System.out.println(obj.findPlatform(arr, dep));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Item
{
    int time;
    char type;
    Item(int time,char type)
    {
        this.time=time;
        this.type=type;
    }
}
class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        Item[] items=new Item[arr.length+dep.length];
        for(int i=0;i<arr.length;i++)
        {
            items[i]=new Item(arr[i],'A');
        }
        for(int i=0;i<dep.length;i++)
        {
            items[i+arr.length]=new Item(dep[i],'D');
        }
        Arrays.sort(items,(a,b)->a.time-b.time);
        int cnt=0,maxcount=Integer.MIN_VALUE;
        for(Item item:items)
        {
            if(item.type=='A')
            {
                cnt++;
                maxcount=Math.max(maxcount,cnt);
            }
            else
            {
                cnt--;
            }
        }
        return maxcount;
    }
}
