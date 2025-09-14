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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> li = new ArrayList<>();
        inOrder(root,li);
        int left=0;
        int right=li.size()-1;
        while(left<right){
            if(li.get(left)+li.get(right)==k) return true;
            else if(li.get(left)+li.get(right)<k) left++;
            else right--;
        }
        return false;
    }
    public void inOrder(TreeNode root, List<Integer>li){
        if(root==null) return;
        inOrder(root.left,li);
        li.add(root.val);
        inOrder(root.right,li);
    }
}
