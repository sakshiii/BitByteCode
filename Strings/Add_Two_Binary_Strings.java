// Given two binary strings (strings containing only 1s and 0s) return their sum (also as a binary string).
// Note: neither binary string will contain leading 0s unless the string itself is 0

// Ex: Given the following binary strings...

// "100" + "1", return "101"
// "11" + "1", return "100"
// "1" + "0", return  "1"


import java.util.Scanner;

public class Add_Binary_Strings {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		String s1=sc.next();
		String s2=sc.next();
		int i=s1.length()-1;
		int j=s2.length()-1;
		int c=0;
		StringBuilder sb=new StringBuilder();
		while(i>=0 || j>=0)
		{
			int s=0;
			s+=c;
			if(i>=0) s+=s1.charAt(i)-'0';
			if(j>=0) s+=s2.charAt(j)-'0';
			c=s/2;
			sb.append(s%2);
			i--;
			j--;
		}
		if(c!=0) sb.append(c);
		System.out.println(sb.reverse());
	}

}
