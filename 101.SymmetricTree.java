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
    public boolean checker(TreeNode r1, TreeNode r2){
        if(r1==null||r2==null){
            //Returns true if both are null else false
            return r1==r2;
        }
        if(r1.val==r2.val){
            boolean leftAns = checker(r1.left,r2.right);
            boolean rightAns = checker(r1.right,r2.left);
            return leftAns && rightAns;
        }
        else{
            return false;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        /*
            Approach : 
            TC : O(N)
            SC : O(1)
            1.Make a function that takes or starts from the left and right of the root.
            2.Check if either of the left and right is null, if they are both null return true, if only one is true return false.
            3.Check if the values of both are equal or not, if no then return false.
            4.Now that if the values of left and right are equal we need to check that their children follow the mirror property or not which is :
                  R1->Left = R2->Right and R1->Right = R2->Left
              For checking this simply call the same function for the above nodes and store their ans in a boolean var.
            5.Return the AND of the answer of both the above two mirror properties.
        */
        if(root==null) return true;
        return checker(root.left,root.right);
    }
}
