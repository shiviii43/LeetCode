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
            TC:O(n)
            SC:O(n)
            1.Since we know that the inOrder Traversal of a BST always result in a sorted array.
            2.We will traverse the BST using the InOrder Traversal and store the elements in a array.
            3.Once all the Nodes of the Trees are traversed, check if the resulting array is sorted or not.
            3.Return true or false according to the resulting array.

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list = inOrder(root,list);
        for(int i=1;i<list.size();i++){
            if(list.get(i)<=list.get(i-1)){
                return false;
            }
        }
        return true;
    }
    public List<Integer> inOrder(TreeNode root,List<Integer> li){
        if(root==null){
            return null;
        }
        inOrder(root.left,li);
        li.add(root.val);
        inOrder(root.right,li);
        return li;
    }

        Optimized Approach : 
        TC:O(n)
        SC:O(1)
        1.The root has no restriction as it can lie between -infinity to infinity, so the root will have no restrictions.
        2.For the LEFT SUBTREE of the root, the elements can lie between -infinity and the root's value.
        3.For the RIGHT SUBTREE of the root, the elements can lie between the root's value and infinity.
        4.Use two variables min and max which keeps the track of min & max.

    */
    public boolean isValidBST(TreeNode root) {
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean helper(TreeNode root, long min, long max){
        if(root==null) return true;
        else if(root.val<=min || root.val>=max) return false;
        boolean l = helper(root.left,min,root.val);
        boolean r = helper(root.right,root.val,max);
        return l && r;
    }
}
