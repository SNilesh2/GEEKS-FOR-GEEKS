// User function Template for Java

class Solution {
    static int solve(int bt[]) {
        // code here
        Arrays.sort(bt);
        int sum=0;
        int wt=0;
        for(int i=0;i<bt.length-1;i++)
        {
            sum=sum+bt[i];
            wt=wt+sum;
        }
        return wt/bt.length;
    }
}
