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
    public boolean isUnivalTree(TreeNode root) {
        /* 
            Approach 1 :
            TC: O(N)  where N is the number of nodes in the Binary Tree
            SC:O(1)
            1.Compare the value at the root with the values in the tree.
            2.Use any one of the Tree Traversal, so check and compare the value at every node with the value at the root.

            Make a funtion that takes the root and the value at the root and then traverse the Tree Recursively and checks.
        */
        return checker(root,root.val);
    }
    public boolean checker(TreeNode root, int val){
        //Check for null 
        if(root==null) return true;
        //Check for the condition/value comparison
        if(root.val!=val) return false;
        //Checking the same for the leftSubtree and the rightSubtree
        boolean leftSubTree = checker(root.left,val);
        boolean rightSubTree = checker(root.right,val);
        //The function will return true only when both the subtrees are true
        return leftSubTree && rightSubTree;
    }
}
