//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }

            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            n = a2.length;
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(a2[i]);
            }

            int ans = new Solution().maxMeetings(a, b);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Item
{
    int s,e;
    Item(int s,int e)
    {
        this.s=s;
        this.e=e;
    }
}
class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        Item[] items=new Item[start.length];
        for(int i=0;i<start.length;i++)
        {
            items[i]=new Item(start[i],end[i]);
        }
        Arrays.sort(items,(a,b)->a.e-b.e);
        int cnt=0,freetime=-1;
        for(Item item:items)
        {
            if(item.s > freetime)
            {
                cnt++;
                freetime=item.e;
            }
        }
        return cnt;
    }
}