/* Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2.
*/

import java.io.*;
import java.util.*;
import java.lang.*;

class FirstUnique{
    
    public static int funique(String s)
    {
        
        HashMap<Character,Integer> h=new HashMap<Character,Integer>();
        int c=0,f=0;
        for(int i=0;i<s.length();i++)
        {
            h.put(s.charAt(i),h.getOrDefault(s.charAt(i),0)+1);
        }
       
        for(int i=0;i<s.length();i++)
        {
        
            if(h.get(s.charAt(i))==1)
            {
                return i;
            } 
        }
        
        return -1
    }
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
	    String str=sc.next();
	    int ans=funique(str);
	    System.out.println(ans);
		
	}
}