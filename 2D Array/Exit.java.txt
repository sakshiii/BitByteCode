//Exit Point in a matrix
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Exit{
	public static void main (String[] args) {
		
		Scanner sc=new Scanner(System.in);
	int t=sc.nextInt();
	while(t-->0){
		int m=sc.nextInt();
		int n=sc.nextInt();
		int[][] mat=new int[m][n];
		for(int k=0;k<m;k++)
		{
		    for(int l=0;l<n;l++)
		        mat[k][l]=sc.nextInt();
		}
		
		int i=0,j=0,pi=0,pj=0,d=0;
		while(i<m && j<n && i>=0 && j>=0)
		{
		    pi=i;
		    pj=j;
		    
		    if(mat[i][j]==1)
		    {
		        d=(d+1)%4;
		        mat[i][j]=0;
		    }
		    
		    if(d==0)
		        j++;
		        
		    else if(d==1)
		        i++;

		    else if(d==2)
		        j--;
		        
		    else if(d==3)
                i--;
            
            
		    
		}
		System.out.print(pi+" "+pj);
		System.out.println();
	}
	}
}