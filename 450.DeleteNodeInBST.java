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

 /*
    CASES :
        1.When the node has no children.
        2.When the node has one child.
        3.When the node has two childrem.

            1.If the node to be deleted has no children then simply reach the node before that node and make it point null.
            2.If the node has a single child then simply reach the node before the node and make it point the child of the deleted node.
            3.If the node has two children then replace the node to be deleted with its InOrder Successor or InOrder Predecessor.
            [InOrder Successor is prefered as it's consistent.]

        Approach : 
        1.Search for the node to be deleted.
        2.Check for the Cse which need to be applied.
        3.Replace the node with another node and delete the copy of the replaced node from the rightSubTree.
*/
class Solution {
    private TreeNode minNode(TreeNode r){
        while(r.left!=null) r = r.left;
        return r;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
       if(root==null) return null;
       else if(root.val>key){
        root.left = deleteNode(root.left,key);
       }
       else if(root.val<key){
        root.right = deleteNode(root.right,key);
       }
       else{
        //Meaning the node is found.
        if(root.left==null) return root.right;
        else if(root.right==null) return root.left;
        else {
            TreeNode succ = minNode(root.right);
            root.val = succ.val;
            root.right = deleteNode(root.right,root.val);
            }
        }   
    return root;
    }
}
