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
    public void postOrder(TreeNode root,ArrayList<Integer> li){
        if(root==null) return;
        //Call for the LeftSubTree
        postOrder(root.left,li);
        //Call for the RightSubTree
        postOrder(root.right,li);
        li.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        /*
            POST ORDER -> Left,Right,Root

            Approach : 
            TC : O(N)
            SC : O(1)
            1.Create a function that calls itself first for the LeftSubTree.
            2.Then the RightSubTree and then inserts the value into a List.
        */
        ArrayList<Integer> li = new ArrayList<>();
        postOrder(root,li);
        return li;
    }
}
