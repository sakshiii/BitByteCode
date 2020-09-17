// Given a string and the ability to delete at most one character, return whether or not it can form a palindrome.
// Note: a palindrome is a sequence of characters that reads the same forwards and backwards.

// Ex: Given the following strings...

// "abcba", return true
// "foobof", return true (remove the first 'o', the second 'o', or 'b')
// "abccab", return false

import java.io.*;
import java.lang.*;
import java.util.*;

class ValidPalindrome{
    
    public static boolean isPal(String s,int l,int h)
    {

        while(l<h)
        {
            if(s.charAt(l)!=s.charAt(h))
                return false;
            l++;
            h--;
        }
        return true;
    }
    public static int fun(String s)
    {
        int l=0,h=s.length()-1;
        while(l<h)
        {
            if(s.charAt(l)==s.charAt(h))
            {
                l++;
                h--;
            }
            else{
                
                if(isPal(s,l+1,h))
                    return l;
                else if(isPal(s,l,h-1))
                    return h;
                    
            }
        }
        return -1;
    }
	public static void main (String[] args) {
	    
	    Scanner sc=new Scanner(System.in);
	    String check=sc.next();
	    int x=fun(check);
	    if(x>=0)
	        System.out.println(check.charAt(x));
	   else
	        System.out.println("NO");
	}
}