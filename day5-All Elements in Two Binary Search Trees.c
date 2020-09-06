Given two binary search trees root1 and root2.

Return a list containing all the integers from both trees sorted in ascending order.

 

Example 1:


Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]
Example 2:

Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
Output: [-10,0,0,1,2,5,7,10]
Example 3:

Input: root1 = [], root2 = [5,1,7,0,2]
Output: [0,1,2,5,7]
Example 4:

Input: root1 = [0,-10,10], root2 = []
Output: [-10,0,10]
Example 5:


Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]
 

Constraints:

Each tree has at most 5000 nodes.
Each node's value is between [-10^5, 10^5].
   Show Hint #1  
   Show Hint #2  
C	
1
/**
2
 * Definition for a binary tree node.
3
 * struct TreeNode {
4
 *     int val;
5
 *     struct TreeNode *left;
6
 *     struct TreeNode *right;
7
 * };
8
 */
9
​
10
​
11
/**
12
 * Note: The returned array must be malloced, assume caller calls free().
13
 */
14
int total(struct TreeNode* root){
15
    int count=1;
16
    if(root==NULL){
17
        return 0;
18
    }else{
19
      //  printf("%d",count);
20
    count+=total(root->right);
21
    count+=total(root->left);
22
    
23
    }
24
    return count;
25
} 
26
void inorder(struct TreeNode *root,int* arr,int* pointer){
27
    if(root==NULL){
28
        return ;
29
    }else{
30
        //arr[pointer]=root->left->v;
31
        inorder(root->left,arr,pointer);
32
        arr[*pointer]=(root->val);
33
        
34
        printf("%d %d \n",*pointer,arr[*pointer]);
35
        *pointer=*pointer+1;
36
        inorder (root->right,arr,pointer);
37
    }
38
}
39
​
40
int* getAllElements(struct TreeNode* root1, struct TreeNode* root2, int* returnSize){
41
    
42
    *returnSize=0;
43
    
44
    int num1=total(root1);
45
    int num2=total(root2);
46
    
47
    int *arr1=(int*)malloc(sizeof(int)*num1);
48
    int *arr2=(int*)malloc(sizeof(int)*num2);
49
    
50
    int i,j,suma1=0,suma2=0;
51
    inorder(root1,arr1,&suma1);
52
    inorder(root2,arr2,&suma2);
53
​
54
        
55
  int p1=0,p2=0;
56
  int *ans=(int*)malloc(sizeof(int)*(num1+num2));
57
    int p3=0;
58
  while(p1<num1 && p2<num2){
59
    if(arr1[p1]>arr2[p2]){
60
        ans[p3]=arr2[p2];
61
        p2++;
62
        p3++;
63
    }else{
64
        ans[p3]=arr1[p1];
65
        p1++;
66
        p3++;
67
    }
68
      printf("%d",ans[p3]);
69
  }
70
    while(p1<num1){
71
        ans[p3]=arr1[p1];
72
        p1++;
73
        p3++;
74
        
75
    }
76
     while(p2<num2){
77
        ans[p3]=arr2[p2];
78
        p2++;
79
        p3++;
80
        
81
    }
82
    *returnSize=p3;
83
    
84
    return ans;
85
}
