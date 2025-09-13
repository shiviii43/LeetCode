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
    int sum=0;
    public int deepestLeavesSum(TreeNode root) {
        /*
            Approach 1 : 
            *Breadth First Search*
            1.Traverse the Tree through Level Order Traversal.
            2.Calculate the sum of elements in the Level.
            3.For each level refresh the Sum variable so that we can only have the sum of the last level which provides us with our answer.

        Queue<TreeNode> main = new LinkedList<>();
        Queue<TreeNode> helper = new LinkedList<>();
        main.add(root);
        int sum = 0;
        while(main.size()!=0){
            TreeNode t = main.remove();
            sum+=t.val;
            if(t.left!=null) helper.add(t.left);
            if(t.right!=null) helper.add(t.right);
            if(main.size()==0){
                main=helper;
                if(main.size()!=0) sum=0;
                helper= new LinkedList<>();
            }
        }
        return sum;

            Approach 2 :
            *Depth First Search*
            1.Find out the height of the Tree.
            2.Since we need to find the sum of nodes in the last level, we will traverse the tree and keep decrementing the height until we reach the last level, and once we reach the last level we add the values to the sum.

        */
        
        int h = height(root);
        calSum(root,h);
        return sum;
    }
    public int height(TreeNode root){
        if(root==null)return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh)+1;
    }
    public void calSum(TreeNode root, int h){
        if(root==null) return;
        else if(h==1) sum+=root.val;
        calSum(root.left,h-1);
        calSum(root.right,h-1);
    }
}
