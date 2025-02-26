//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Using a Set to remove duplicates
            Set<Integer> uniqueElements = new LinkedHashSet<>();
            for (String token : tokens) {
                uniqueElements.add(Integer.parseInt(token));
            }

            // Converting the set to an array
            int[] arr = new int[uniqueElements.size()];
            int idx = 0;
            for (int num : uniqueElements) {
                arr[idx++] = num;
            }

            // Finding and printing subsets
            ArrayList<ArrayList<Integer>> res = new Solution().subsets(arr);
            for (ArrayList<Integer> subset : res) {
                if (subset.size() == 0) {
                    System.out.println("[]");
                } else {
                    for (int num : subset) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                }
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int arr[]) {
        // code here
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        int n=arr.length;
        //Arrays.sort(nums);
        findSubsets(arr,0,n,res,new ArrayList<>());
        return res;
    }
    public static void findSubsets(int[] nums,int ind,int n,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> ds)
    {
        res.add(new ArrayList<>(ds));
        for(int i=ind;i<n;i++)
        {
            //if(i>ind && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            findSubsets(nums,i+1,n,res,ds);
            ds.remove(ds.size()-1);
        }
    }
}