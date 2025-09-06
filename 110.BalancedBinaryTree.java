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
            TC:O(n*n) -> O(n) for checking height and O(n) for doing this complete procedure for each Node in the tree.
            SC:O(1)

            For each node we have a difference of the height of its right tree and the left tree, which should be less than or equal to 1.
            We need to make a height function which calculates and returns the height of the tree provided.
    //Code
    public boolean isBalanced(TreeNode root) {
        //Edge case
        if(root==null) return true;

        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        if(Math.abs(leftHeight-rightHeight)>1) return false;
        boolean l = isBalanced(root.left);
        boolean r = isBalanced(root.right);
        return l && r;
    }
    public static int height(TreeNode root){
        if(root==null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left,right)+1;
    }
        Approach 2 : 
        TC:O(n)
        SC:O(1)
        Do not check twice and check in the height function itself.
        Simply make a global variable which keeps the track of the Balancing Factor.

    */
    boolean balancingFactor = true;
    public boolean isBalanced(TreeNode root) {
        int h = height(root);
        return balancingFactor;
    }
    public int height(TreeNode root){
        if(root==null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        //Checking for balancing factor
        if(Math.abs(lh-rh)>1){
            balancingFactor = false;
        }
        return Math.max(lh,rh)+1;
    }
}
