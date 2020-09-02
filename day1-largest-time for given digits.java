LeetCode
Largest Time for Given Digits

Question-
Given an array of 4 digits, return the largest 24 hour time that can be made.

The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.

Return the answer as a string of length 5.  If no valid time can be made, return an empty string.

 

Example 1:

Input: [1,2,3,4]
Output: "23:41"
Example 2:

Input: [5,5,5,5]
Output: ""
 

Note:

A.length == 4
0 <= A[i] <= 9


Java	


1
class Solution {
2
    public String largestTimeFromDigits(int[] A) {
3
     
4
        String res="";
5
        //1 way is to generate all the possible permutations and check which one is correct
6
        //the below method is a simpler method to generate all possible permutations
7
        
8
        for(int i=0;i<4;i++)    //since given array has 4 values
9
        {
10
            for(int j=0;j<4;j++)
11
            {
12
                for(int k=0;k<4;k++)
13
                {
14
                    if(i==j||j==k||i==k)    //removing repetitions
15
                        continue;
16
                    else
17
                    {   //converting to string with ""
18
                        String hour=A[i] + "" + A[j];   //you can put any combination,A[i]-A[j],A[j]-A[k](since its permuting anyways)
19
                        String min=A[k] + "" + A[6-i-j-k];//total sum of indexes=6..to get remaining value
20
                        String time=hour+":"+min;
21
                        //now check if this permuted combination is <24 & all that
22
                        if(hour.compareTo("24")<0 && min.compareTo("60")<0 && res.compareTo(time)<0)
23
                        {
24
                            //.compareTo compares 2 strings
25
                            //put 24 & 60 in ""..since you have to compare it as string & not as number
26
                            res=time;
27
                            //compare res & time..since we need max possible output..check with res & assign the value
28
                        }
29
                    }
30
                }
31
            }
32
        }
33
        return res;
34
        
35
    }
36
}
  Custom Testcase( Contribute  )
Submission Result: Accepted 
Share your acceptance!
20
