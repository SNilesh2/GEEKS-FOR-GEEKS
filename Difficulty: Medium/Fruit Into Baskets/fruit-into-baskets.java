//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            // Convert ArrayList to array
            Integer[] arr = new Integer[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call totalFruits method and print result
            Integer ans = ob.totalFruits(arr);
            System.out.println(ans);

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(Integer[] arr) {
        // code here
        HashMap<Integer,Integer> map=new HashMap<>();
        int left=0,right=0,maxlength=0;
        while(right<arr.length)
        {
            int value=map.getOrDefault(arr[right],0);
            map.put(arr[right],value+1);
            if(map.size()>2)
            {
                map.put(arr[left],map.getOrDefault(arr[left],0)-1);
                if(map.get(arr[left]) == 0) 
                {
                    map.remove(arr[left]);
                }
                left++;
            }
            if(map.size()<=2)
            {
                maxlength=Math.max(maxlength,right-left+1);
            }
            right++;
        }
        return maxlength;
    }
}