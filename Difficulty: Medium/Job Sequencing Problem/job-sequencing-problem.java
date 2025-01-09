//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

class GfG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] jobIDStrings = sc.nextLine().split(" ");
            String[] deadlineStrings = sc.nextLine().split(" ");
            String[] profitStrings = sc.nextLine().split(" ");

            // Convert the input strings to integer arrays
            int[] jobIDs = new int[jobIDStrings.length];
            int[] deadlines = new int[deadlineStrings.length];
            int[] profits = new int[profitStrings.length];

            for (int i = 0; i < jobIDStrings.length; i++) {
                jobIDs[i] = Integer.parseInt(jobIDStrings[i]);
                deadlines[i] = Integer.parseInt(deadlineStrings[i]);
                profits[i] = Integer.parseInt(profitStrings[i]);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.JobSequencing(jobIDs, deadlines, profits);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Item
{
    int i,d,p;
    Item(int i,int d,int p)
    {
        this.i=i;
        this.d=d;
        this.p=p;
    }
}
  


class Solution {

    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        // code here..
        ArrayList<Integer> res=new ArrayList<>();
        Item[] items=new Item[id.length];
        for(int i=0;i<id.length;i++)
        {
            items[i]=new Item(id[i],deadline[i],profit[i]);
        }
        Arrays.sort(items,(a,b)->b.p-a.p);
        int[] hasharray=new int[id.length+1];
        Arrays.fill(hasharray,-1);
        int maxprofit=0,noofjob=0;
        for(Item item:items)
        {
            int dead=item.d;
            while(dead>0)
            {
                if(hasharray[dead]==-1)
                {
                    hasharray[dead]=item.i;
                    noofjob++;
                    maxprofit=maxprofit+item.p;
                    break;
                }
                dead--;
            }
        }
        res.add(noofjob);
        res.add(maxprofit);
        return res;
    }
}
