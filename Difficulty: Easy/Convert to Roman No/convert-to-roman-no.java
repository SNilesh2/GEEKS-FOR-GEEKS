//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int N = sc.nextInt();
			
			Solution ob = new Solution();
			System.out.println(ob.convertToRoman(N));
			t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
	String convertToRoman(int n) {
		//code here
		Map<Integer,String> romanMap=new LinkedHashMap<>();
           romanMap.put(1000,"M");
           romanMap.put(900,"CM");
           romanMap.put(500,"D");
           romanMap.put(400,"CD");
           romanMap.put(100,"C");
           romanMap.put(90,"XC");
           romanMap.put(50,"L");
           romanMap.put(40,"XL");
           romanMap.put(10,"X");
           romanMap.put(9,"IX");
           romanMap.put(5,"V");
           romanMap.put(4,"IV");
           romanMap.put(1,"I");
           StringBuilder roman=new StringBuilder();
           for(Map.Entry<Integer,String> entry : romanMap.entrySet())
           {
            while(n>=entry.getKey())
            {
                n=n-entry.getKey();
                roman.append(entry.getValue());
            }
           }
           return roman.toString();
	}
}