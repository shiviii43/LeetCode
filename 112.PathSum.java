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

        Brute Force Approach : 
        TC:O(h) where h is the height of the Tree.
        SC:O(M) where M are the number of leaf nodes in the tree
        1.We can calculate the path sum to each root to leaf node of tree.
        2.Construct an array list which stores these Path sums.
        3.After all the path sums have been inserted, iterate the List and check if there exists a path sum which is equal to the target.

        Approach : 
        TC:O(h) where h is the height of the Tree.
        SC:O(1)
        *Path Sum Algorithm*
        For each node reduce the target sum by the value of the node and then pass that value as the new target of its left and right child.
        If there is no child next to a node and the node contains the value that is in the target then return True.
        Call the same function with the the new subtracted value for the left and the rightSubTree of the current root.

    */ 
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        if(root.left==null && root.right==null && root.val==targetSum) return true;
        boolean lt = hasPathSum(root.left,targetSum-root.val);
        boolean rt = hasPathSum(root.right,targetSum-root.val);
        return lt||rt;
    }
}
