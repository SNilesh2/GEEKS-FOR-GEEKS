//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int[] leftRow = new int[n];
        int[] upperDiag = new int[2 * n - 1];
        int[] lowerDiag = new int[2 * n - 1];
        solve(0, board, res, leftRow, upperDiag, lowerDiag);
        return res;
    }

    public static void solve(int col, char[][] board, ArrayList<ArrayList<Integer>> res, int[] leftRow, int[] upperDiag, int[] lowerDiag) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0 && upperDiag[row + col] == 0 && lowerDiag[board.length - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                upperDiag[row + col] = 1;
                lowerDiag[board.length - 1 + col - row] = 1;
                solve(col + 1, board, res, leftRow, upperDiag, lowerDiag);
                board[row][col] = '.';
                leftRow[row] = 0;
                upperDiag[row + col] = 0;
                lowerDiag[board.length - 1 + col - row] = 0;
            }
        }
    }

    public static ArrayList<Integer> construct(char[][] board) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int col = 0; col < board.length; col++) {
            for (int row = 0; row < board.length; row++) {
                if (board[row][col] == 'Q') {
                    ans.add(row + 1);
                    break;
                }
            }
        }
        return ans;

    }
}