//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends

class Pair
{
    String str;
    Integer cnt;
    Pair(String _str,Integer _cnt)
    {
        this.str=_str;
        this.cnt=_cnt;
    }
}
class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        HashSet<String> set=new HashSet<>();
        for(String s:wordList)
        {
            set.add(s);
        }
        Queue<Pair> q=new LinkedList<>(); 
        if(set.contains(startWord)==true)
        {
            set.remove(startWord);
        }
        q.add(new Pair(startWord,1));
        while(!q.isEmpty())
        {
            Pair pr=q.poll();
            String str=pr.str;
            Integer cnt=pr.cnt;
            if(str.equals(targetWord)==true) return cnt;
            for(int i=0;i<str.length();i++)
            {
                for(char ch='a';ch<='z';ch++)
                {
                    char[] replace=str.toCharArray();
                    replace[i]=ch;
                    String s=new String(replace);
                    if(set.contains(s)==true)
                    {
                        set.remove(s);
                        q.add(new Pair(s,cnt+1));
                    }
                }
            }
        }
        return 0;
    }
}