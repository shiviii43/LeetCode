/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    /*
        Approach : 
        We have to find the value which is common for both the given values, and with it we have to make sure then it is the lowest.
        If both our values are smaller than the root value then we need to Traverse the LeftSubTree.
        If both our values are larger than the root value then we need to Traverse the RightSubTree.
        If there exists a Node for which one value is less than the root and another is greater then the root, then return that node as the answer.

    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        TreeNode temp = root;
        while(temp!=null){
            if(temp.val>p.val && temp.val>q.val){
                temp=temp.left;
            }
            else if(temp.val<p.val && temp.val<q.val){
                temp=temp.right;
            }
            else{
                break;
            }
        }
        return temp;
    }
}
