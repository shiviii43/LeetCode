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
    public int countNodes(TreeNode root) {
        /*
            Approach :
            TC:O(N)
            SC:O(1)

            We have to find the number of nodes in the LeftSubTree and the number of nodes in the RightSubTree.
            We can simply call the same function again for the left and the right subTree until we reach a base condition of reaching a null node.
            After calculating the number of nodes in the left and the right subtree simply add 1 as we need to include the root as well.
            If there is no node in the Tree then simply return 0.
        */
        if(root==null) return 0;

        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return leftCount+rightCount+1;
    }
    
}
