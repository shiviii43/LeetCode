/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /*
        Approach 1 : 
            1.Create a Priority Queue.
            2.Insert all the values of the Trees into the Priority Queue.
            3.Remove till k from the Priority Queue and then return it as the answer.
            TC:O(N)+O(N) => O(N) [N of inserting into the heap ans N of the worst case of removing the maximum element from the Tree]
            SC:O(N)

        Approach 2 : 
            *Depth-First Search*
            The DFS has traversals which are preOrder, InOrder and PostOrder
            And we know that applying InOrder Traversal in a Binary Search Tree leads to a Sorted Array.
            Make an Array and store the InOrder Traversal and return k-1.
            TC:O(N)
            SC:O(N)
            //Code
            public void inOrder(TreeNode root,ArrayList<Integer> li){
                if(root==null) return;
                //Left Root Right
                inOrder(root.left,li);
                li.add(root.val);
                inOrder(root.right,li);
            }
            public int kthSmallest(TreeNode root, int k) {
                ArrayList<Integer> ans = new ArrayList<>();
                inOrder(root,ans);
                return ans.get(k-1);
            }

        Approach 3 : 
            TC:O(N)
            SC:O(1)
            Since we know that the inOrder traversal gives us a sorted array, how about we keep a count of how many values we have traversed.
            We will create two global variables count and ans.
            For each value traversed we will update the count variable and once the count is equal to k we will store that value as the final answer.
            Through this way we do not need to store every element of the tree and only the required one.

    */
    int count=0;
    int ans=0;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        return ans;
    }
    public void inOrder(TreeNode root,int k){
        if(root==null)return;
        inOrder(root.left,k);
        count++;
        if(count==k){
            ans=root.val;
        }
        inOrder(root.right,k);
    }
}
