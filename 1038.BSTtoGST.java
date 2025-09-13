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
        *Depth First Search*
        TC:O(N)
        SC:O(1)
        1.Use the modified InOrder Traversal.
            [Right->Root->Left]
        2.For every root, simply add the global greater value and the current value of the node into the root node and return it.

    */
    int val=0;
    public TreeNode bstToGst(TreeNode root) {
        if(root==null) return null;
        bstToGst(root.right);
        val+=root.val;
        root.val=val;
        bstToGst(root.left);
        return root;
    }
}
