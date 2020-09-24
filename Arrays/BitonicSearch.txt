// Given a bitonic sequence A of N distinct elements, write a program to find a given element B in the bitonic sequence in O(logN) time.

// NOTE:

// A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.


// Problem Constraints
// 3 <= N <= 105

// 1 <= A[i], B <= 108

// Given array always contain a bitonic point.

// Array A always contain distinct elements.



// Input Format
// First argument is an integer array A denoting the bitonic sequence.

// Second argument is an integer B.



// Output Format
// Return a single integer denoting the position (0 index based) of the element B in the array A if B doesn't exist in A return -1.



// Example Input
// Input 1:

//  A = [3, 9, 10, 20, 17, 5, 1]
//  B = 20


public class Solution {
    
    public int AO(int [] a,int l,int h,int B) 
    {
    
        while(l<=h)
        {
            int m=l+(h-l)/2;
            if(a[m]==B)
                return m;
                
            if(a[m]<B)
            {
                l=m+1;
            }
            else 
                h=m-1;
        }
        return -1;
    }

    public int DO(int [] a,int l,int h,int B) 
    {
    
        while(l<=h)
        {
            int m=l+(h-l)/2;
            if(a[m]==B)
                return m;
                
            if(a[m]>B)
            {
                l=m+1;
            }
            else 
                h=m-1;
        }
        return -1;
    }
    
    public int FindPeak(int[] a)
    {
        int n=a.length;
        int l=0,h=n-1;
        while(l<h)
        {  
            int mid=l+(h-l)/2;
            
            
            if(a[mid]<a[mid+1])
                l=mid+1;
            else
                h=mid;

        }
        return l;
    }
    
    public int solve(int[] A, int B) {
        
        int n=A.length;
        int l=0,h=n-1;
        int idx=FindPeak(A);
        int asc=AO(A,l,idx-1,B);
        int dsc=DO(A,idx,h,B);
        if(asc==dsc) return -1;
        
        return asc>dsc?asc:dsc;
    }
}
