//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Item
{
    double wei,val,ratio;
    Item(double val,double wei)
    {
        this.wei=wei;
        this.val=val;
        this.ratio=val/wei;
    }
}
class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        // code here
        double weight=0;
        double value=0;
        Item[] items=new Item[val.size()];
        for(int i=0;i<val.size();i++)
        {
            items[i]=new Item(val.get(i),wt.get(i));
        }
        Arrays.sort(items,(a,b)->Double.compare(b.ratio,a.ratio));
        for(Item item:items)
        {
            if(weight+item.wei <= capacity)
            {
                weight=weight+item.wei;
                value=value+item.val;
            }
            else
            {
                value=value + (item.ratio * (capacity-weight));
                break;
            }
        }
        return value;
    }
} 