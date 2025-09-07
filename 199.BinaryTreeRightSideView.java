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
    public List<Integer> rightSideView(TreeNode root) {
        /*
            Approach 1 : 
            TC:O(h) 
            SC:O(h) height of the Tree
            1.Use the Level Order Traversal Approach. [R-->L]
            2.Create a List and for each level insert only the first node's value into the List.
            3.When all the Level are traversed simply return the List.

            Approach 2 : 
            *Depth First Search*
            TC:O(h)
            SC:O(1)
            1.Use the Modified PreOrder Traversal. [Root-->Right-->Left]
            2.Keep the Track of the levels traversed as we have to insert only a single element from each level.

        */
        List<Integer> li = new ArrayList<>();
        preOrder(root,li,0);
        return li;
    }
    public void preOrder(TreeNode root,List<Integer> li,int level){
        if(root==null) return;
        if(li.size()==level){
            li.add(root.val);
        }
        preOrder(root.right,li,level+1);
        preOrder(root.left,li,level+1);
    }
}
