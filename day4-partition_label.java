A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

 

Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 

Note:

S will have length in range [1, 500].
S will consist of lowercase English letters ('a' to 'z') only.
 

   Show Hint #1  
Java	
length-the length of previous substring
1
class Solution {
2
    public List<Integer> partitionLabels(String S) {
3
        int[] last=new int[26];         //array to store the last index position of each charachter in string
4
        for(int i=0;i<S.length();i++)
5
        {
6
            last[S.charAt(i)-'a']=i;
7
        }
8
        
9
        int j=0,temp=0;
10
        List<Integer> ans=new ArrayList();
11
        for(int i=0;i<S.length();i++)
12
        {
13
            j=Math.max(j,last[S.charAt(i)-'a']);    //so,s[i]='a'-'a'..so go to that position in list array
14
            if(i==j)
15
            {
16
                ans.add(i-temp+1);          
17
                temp=i+1;               //so that total length-the length of previous substring
18
            }
19
        }
20
        return ans;
21
    }
22
}
