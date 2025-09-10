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
            Approach : 
            TC:O(log N)
            SC:O(1)
            The base case is if we reach a null element then we simply add the node we want to add at that position.
            If the root is greater then the value means we need to call the same function for the LeftSubTree.
            If the root is less then the value means we need to call the same function for the RightSubTree.
        */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        else if(root.val>val){
            root.left=insertIntoBST(root.left,val);
        }
        else if(root.val<val){
            root.right=insertIntoBST(root.right,val);
        }
        return root;
    }
}
