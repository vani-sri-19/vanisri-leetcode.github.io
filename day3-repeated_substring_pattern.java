Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

 

Example 1:

Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
Example 2:

Input: "aba"
Output: False
Example 3:

Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)

1
class Solution {
2
    public boolean repeatedSubstringPattern(String s) {
3
       int n=s.length();
4
       for(int i=n/2;i>0;i--){  //the total length must be a multiple of substring..abc=3..abcabc=6
5
           //we are checking for all the factors
6
        if(n%i==0)  //checking if its a multiple
7
        {
8
            int left=0;
9
            int right=i;    //abcxyz..here left=a,right=x
10
            while(right<n && s.charAt(left)==s.charAt(right))//check if each char from a to c is equal to x to z
11
            {
12
                left++;
13
                right++;
14
                if(right==n)    //if reached until end
15
                    return true;
16
                
17
            }
18
        }
19
       }
20
        return false;
21
    }
22
}
