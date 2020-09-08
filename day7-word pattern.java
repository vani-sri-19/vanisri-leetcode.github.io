Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.


1
class Solution {
2
    public boolean wordPattern(String pattern, String str) {
3
        Map<Character, String> map = new HashMap<>();   //using Maps
4
        Set<String> set = new HashSet<>();              //another hashset
5
        String[] strValues=str.split(" ");         //splitting string based on space & storing it in string array
6
        if(strValues.length !=pattern.length()) {
7
            return false;
8
        }
9
​
10
        for(int i=0;i<pattern.length();i++){
11
            Character key = pattern.charAt(i);     //first time key has 'a' ( test case 1)
12
            String strValue = strValues[i];        //first time strvalue has "dog"
13
            if(map.containsKey(key)){               //containsKey method to check if a is present in first map
14
                String existingValue = map.get(key);  //get method gets value of that key
15
                if(!existingValue.equals(strValue)){
16
                    return false;
17
                }
18
            } else {
19
               if(set.contains(strValue)){      //map checks based on key, set checks str value
20
                   return false;
21
               } else{
22
                   set.add(strValue);
23
                    map.put(key, strValue);
24
                }
25
            }
26
            }
27
        
28
        return true;
29
    }
30
}
